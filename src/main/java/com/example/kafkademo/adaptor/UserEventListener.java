package com.example.kafkademo.adaptor;

import com.example.kafkademo.adaptor.dto.UserEventKey;
import com.example.kafkademo.adaptor.dto.UserEventValue;
import com.example.kafkademo.application.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventListener extends DefaultEventListener<UserEventKey, UserEventValue> {

    private final UserCommandService userCommandService;

    @Override
    @KafkaListener(
            topics = "${kafka.topic.user.name}",
            containerFactory = "kafkaUserListenerContainerFactory"
    )
    public void listen(
            @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY) UserEventKey userEventKey,
            @Payload(required = false) UserEventValue userEventValue
    ) {
        consume(userEventKey, userEventValue);
    }

    @Override
    public void consumeEvent(UserEventKey userEventKey, UserEventValue userEventValue) {
        if (userEventKey.getId() > 0) {
            userCommandService.update(userEventKey, userEventValue);
            return;
        }
        userCommandService.save(userEventKey, userEventValue);
    }

    @Override
    public void consumeTombstoneEvent(UserEventKey userEventKey) {
        userCommandService.delete(userEventKey);
    }
}
