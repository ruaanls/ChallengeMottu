#!/bin/bash
set -e  # Encerra se qualquer comando falhar

echo "🚀 Iniciando Zookeeper..."
/opt/kafka/bin/zookeeper-server-start.sh /opt/kafka/config/zookeeper.properties &
sleep 5

echo "🚀 Iniciando Kafka..."
/opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties &
sleep 10

echo "✅ Kafka iniciado. Iniciando aplicação Java..."
exec java -jar app.jar