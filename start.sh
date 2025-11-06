#!/bin/bash
set -e

echo "🚀 Iniciando Zookeeper..."
/opt/kafka/bin/zookeeper-server-start.sh -daemon /opt/kafka/config/zookeeper.properties
sleep 5

echo "🚀 Configurando e iniciando Kafka..."
HOST_IP=$(hostname -i)
echo "advertised.listeners=PLAINTEXT://${HOST_IP}:9092" >> /opt/kafka/config/server.properties
echo "listeners=PLAINTEXT://0.0.0.0:9092" >> /opt/kafka/config/server.properties

# Inicia o Kafka em background
/opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties &
sleep 7

echo "✅ Kafka iniciado com sucesso na porta 9092."
echo "🚀 Iniciando aplicação Java..."
exec java -jar app.jar
