package com.example.kafkademo.application;

import com.example.kafkademo.adaptor.dto.UserEventKey;
import com.example.kafkademo.adaptor.dto.UserEventValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserCommandService {

    public void save(UserEventKey userEventKey, UserEventValue userEventValue) {
        // TODO: 2021/08/02 
    }

    public void update(UserEventKey userEventKey, UserEventValue userEventValue) {
        // TODO: 2021/08/07
    }

    public void delete(UserEventKey userEventKey) {
        // TODO: 2021/08/02  
    }
}
