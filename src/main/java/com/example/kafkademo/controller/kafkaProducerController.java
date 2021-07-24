package com.example.kafkademo.controller;

import com.example.kafkademo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class kafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping(value = "/sendMessage")
    public void sendMessage(String message) {
        kafkaProducerService.sendMessage(message);
    }
}
