package com.example.kafkademo.adaptor;

import com.example.kafkademo.adaptor.template.KafkaDemoTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaDemoTemplate kafkaDemoTemplate;

    public void send(String message) {
        kafkaDemoTemplate.send(message);
    }
}
