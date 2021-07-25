package com.example.kafkademo.api;

import com.example.kafkademo.adaptor.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class kafkaProducerController {

    private final KafkaProducer kafkaProducer;

    @PostMapping(value = "/sendMessage")
    public void sendMessage(String message) {
        kafkaProducer.sendMessage(message);
    }
}
