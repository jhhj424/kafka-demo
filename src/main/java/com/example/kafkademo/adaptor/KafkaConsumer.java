package com.example.kafkademo.adaptor;

import com.example.kafkademo.adaptor.dto.ConsumerKey;
import com.example.kafkademo.adaptor.dto.ConsumerValue;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(
            topics = "${kafka.topic.demo.name}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(
            @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY) ConsumerKey consumerKey,
            @Payload(required = false) ConsumerValue consumerValue
    ) {
        System.out.println("consumerKey = " + consumerKey);
        System.out.println("consumerValue = " + consumerValue);
    }
}
