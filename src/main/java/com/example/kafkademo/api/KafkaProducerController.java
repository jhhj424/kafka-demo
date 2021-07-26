package com.example.kafkademo.api;

import com.example.kafkademo.application.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping(value = "/send")
    public void sendMessage(String message) {
        kafkaProducerService.send(message);
    }
}
