package com.example.kafkademo.application;

import com.example.kafkademo.adaptor.dto.ConsumerKey;
import com.example.kafkademo.adaptor.dto.ConsumerValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    public void save(ConsumerKey consumerKey, ConsumerValue consumerValue) {
        // TODO: 2021/08/02 
    }

    public void delete(ConsumerKey consumerKey) {
        // TODO: 2021/08/02  
    }
}
