package com.example.kafkademo.api;

import com.example.kafkademo.adaptor.dto.ProducerValue;
import com.example.kafkademo.application.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping(value = "/send/{id}")
    public void sendMessage(@PathVariable long id, @RequestBody ProducerValue value) {
        kafkaProducerService.send(id, value);
    }
}
