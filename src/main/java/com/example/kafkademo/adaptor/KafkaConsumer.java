package com.example.kafkademo.adaptor;

import com.example.kafkademo.adaptor.dto.ConsumerKey;
import com.example.kafkademo.adaptor.dto.ConsumerValue;
import com.example.kafkademo.application.KafkaConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class KafkaConsumer implements EventListener<ConsumerKey, ConsumerValue> {

    private final KafkaConsumerService kafkaConsumerService;

    @Override
    @KafkaListener(
            topics = "${kafka.topic.demo.name}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(
            @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY) ConsumerKey consumerKey,
            @Payload(required = false) ConsumerValue consumerValue
    ) {
        consume(consumerKey, consumerValue);
    }

    @Override
    public void consume(ConsumerKey consumerKey, ConsumerValue consumerValue) {
        if (Objects.nonNull(consumerValue)) {
            consumeEvent(consumerKey, consumerValue);
            return;
        }
        consumeTombstoneEvent(consumerKey);
    }

    @Override
    public void consumeEvent(ConsumerKey consumerKey, ConsumerValue consumerValue) {
        kafkaConsumerService.save(consumerKey, consumerValue);
    }

    @Override
    public void consumeTombstoneEvent(ConsumerKey consumerKey) {
        kafkaConsumerService.delete(consumerKey);
    }
}
