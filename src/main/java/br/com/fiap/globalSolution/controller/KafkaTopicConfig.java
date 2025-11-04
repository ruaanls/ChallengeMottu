package br.com.fiap.globalSolution.controller;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig
{
    @Value("motoentrada")
    private String topic1Name;

    @Value("motosaida")
    private String topic2Name;

    @Bean
    public NewTopic produtoscompradosTopic() {
        return TopicBuilder
                .name(topic1Name)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic produtosadicionadosTopic() {
        return TopicBuilder
                .name(topic2Name)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
