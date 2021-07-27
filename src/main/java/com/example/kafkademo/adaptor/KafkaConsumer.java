package com.example.kafkademo.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.demo.name}")
    public void listen(String message) {
        System.out.println("test message = " + message);
    }
}
