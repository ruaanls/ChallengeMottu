FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /build
RUN apk add --no-cache bash
COPY build.gradle settings.gradle ./
COPY gradle/ ./gradle/
COPY gradlew ./
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon --quiet
COPY ./src ./src
RUN ./gradlew build --no-daemon -x test --quiet

# Etapa 2: imagem final com Kafka + aplicação Java
FROM amazoncorretto:21-alpine3.21
WORKDIR /app

# Instala dependências básicas e Kafka
RUN apk add --no-cache bash curl wget tar
RUN wget https://archive.apache.org/dist/kafka/3.9.0/kafka_2.13-3.9.0.tgz && \
    tar -xzf kafka_2.13-3.9.0.tgz && \
    mv kafka_2.13-3.9.0 /opt/kafka && \
    rm kafka_2.13-3.9.0.tgz

# Copia o JAR da sua aplicação
COPY --from=builder /build/build/libs/*-SNAPSHOT.jar app.jar

# Expõe as portas
EXPOSE 8080 9092

# Copia um script de inicialização
COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh

# Define o entrypoint
ENTRYPOINT ["/app/start.sh"]