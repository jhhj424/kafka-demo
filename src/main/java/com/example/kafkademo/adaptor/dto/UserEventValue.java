package com.example.kafkademo.adaptor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEventValue {
    private String name;
    private String email;
}
