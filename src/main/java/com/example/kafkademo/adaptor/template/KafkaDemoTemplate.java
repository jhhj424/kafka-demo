package com.example.kafkademo.adaptor.template;

import com.example.kafkademo.adaptor.dto.ProducerKey;
import com.example.kafkademo.adaptor.dto.ProducerValue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaDemoTemplate {

    private final KafkaTemplate<ProducerKey, ProducerValue> kafkaProducerTemplate;

    @Value("${kafka.topic.demo.name}")
    private String demoTopic;

    public void send(ProducerKey key) {
        kafkaProducerTemplate.send(demoTopic, key, null);
    }

    public void send(ProducerKey key, ProducerValue value) {
        kafkaProducerTemplate.send(demoTopic, key, value);
    }
}
