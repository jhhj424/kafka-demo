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

@Component
@RequiredArgsConstructor
public class KafkaConsumer extends DefaultEventListener<ConsumerKey, ConsumerValue> {

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
    public void consumeEvent(ConsumerKey consumerKey, ConsumerValue consumerValue) {
        kafkaConsumerService.save(consumerKey, consumerValue);
    }

    @Override
    public void consumeTombstoneEvent(ConsumerKey consumerKey) {
        kafkaConsumerService.delete(consumerKey);
    }
}
