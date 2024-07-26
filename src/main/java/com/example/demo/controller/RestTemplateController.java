package com.example.demo.controller;

import com.example.demo.model.UserData;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/RestApi", produces = "application/json")
public class RestTemplateController {

    @GetMapping("/getData")
    public UserData get() {
        UserData userData = new UserData();
        userData.setId("1");
        userData.setUserName("Kim");
        userData.setData("Data send by Rest-API");

        return userData;
    }

    @PostMapping
    public ResponseEntity<UserData> post(@RequestBody UserData userData) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(userData, headers, HttpStatus.CREATED);
    }
}
