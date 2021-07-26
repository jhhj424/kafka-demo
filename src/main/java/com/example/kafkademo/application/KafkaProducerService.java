package com.example.kafkademo.application;

import com.example.kafkademo.adaptor.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaProducer kafkaProducer;

    public void send(String message) {
        kafkaProducer.send(message);
    }
}
