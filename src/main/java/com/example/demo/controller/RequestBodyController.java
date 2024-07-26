package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RequestBodyController {

    @PostMapping("/person")
    public void getBody(@RequestBody Person person) {
        System.out.println(person);
    }
}
