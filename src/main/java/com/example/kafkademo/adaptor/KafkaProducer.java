package com.example.kafkademo.adaptor;

import com.example.kafkademo.adaptor.dto.ProducerKey;
import com.example.kafkademo.adaptor.dto.ProducerValue;
import com.example.kafkademo.adaptor.template.KafkaDemoTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaDemoTemplate kafkaDemoTemplate;

    public void send(ProducerKey key) {
        kafkaDemoTemplate.send(key);
    }

    public void send(ProducerKey key, ProducerValue value) {
        kafkaDemoTemplate.send(key, value);
    }
}
