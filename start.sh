echo "🚀 Iniciando Kafka..."
/opt/kafka/bin/zookeeper-server-start.sh -daemon /opt/kafka/config/zookeeper.properties
sleep 5
/opt/kafka/bin/kafka-server-start.sh -daemon /opt/kafka/config/server.properties

echo "✅ Kafka iniciado. Iniciando aplicação Java..."
java -jar app.jar