package com.example.demo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class UserEntity {
    String id = "1";
    String name = "Kim";
    String userName = "@kkim";
    String email = "kim@email.com";
}
