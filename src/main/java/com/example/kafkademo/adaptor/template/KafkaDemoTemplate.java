package com.example.kafkademo.adaptor.template;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaDemoTemplate {

    private final KafkaTemplate<String, String> kafkaProducerTemplate;

    @Value("${kafka.topic.demo.name}")
    private String demoTopic;

    // key 없는 이벤트 발행
    public void send(String message) {
        kafkaProducerTemplate.send(demoTopic, message);
    }
}
