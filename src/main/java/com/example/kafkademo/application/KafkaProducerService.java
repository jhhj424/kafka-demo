package com.example.kafkademo.application;

import com.example.kafkademo.adaptor.KafkaProducer;
import com.example.kafkademo.adaptor.dto.ProducerKey;
import com.example.kafkademo.adaptor.dto.ProducerValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaProducer kafkaProducer;

    public void send(long id, ProducerValue value) {
        kafkaProducer.send(new ProducerKey(id), value);
    }
}
