package com.example.kafkademo.adaptor;

public class ConsumeEventException extends RuntimeException {
    ConsumeEventException() {
        super("이벤트를 소비할수 없습니다.");
    }
}
