package br.com.fiap.globalSolution.security;

import br.com.fiap.globalSolution.DTO.MotoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessageProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageProducer.class);
    private final KafkaTemplate<String, MotoEvent> motoentradaEvent;
    private final KafkaTemplate<String, MotoEvent> motosaidaEvent;

    public KafkaMessageProducer(KafkaTemplate<String, MotoEvent> motoentradaEvent, KafkaTemplate<String, MotoEvent> motosaidaEvent) {
        this.motoentradaEvent = motoentradaEvent;
        this.motosaidaEvent = motosaidaEvent;
    }

    public void sendMotoEntrada(MotoEvent eventoDto, String topicName)
    {
        CompletableFuture<SendResult<String, MotoEvent>> future = motoentradaEvent.send(topicName, eventoDto);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Evento de entrada de moto enviado com sucesso: {} para o tópico '{}', offset: {}",
                        eventoDto.getPlaca(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().offset());

            } else {
                log.error("Falha ao enviar evento de produto: {}", ex.getMessage());
            }
        });
    }

    public void sendMotoSaida(MotoEvent eventoDto, String topicName)
    {
        CompletableFuture<SendResult<String, MotoEvent>> future = motosaidaEvent.send(topicName, eventoDto);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Evento de entrada de moto enviado com sucesso: {} para o tópico '{}', offset: {}",
                        eventoDto.getPlaca(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().offset());

            } else {
                log.error("Falha ao enviar evento de produto: {}", ex.getMessage());
            }
        });
    }

}
