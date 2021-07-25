package com.example.kafkademo.adaptor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.demo.name}")
    private String topicName;

    public void sendMessage(String message) {

        this.kafkaTemplate.send(topicName, "지토 메세지 테스트", message);
    }
}
