package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ValidEmployee;

import jakarta.validation.Valid;

@RestController
public class ValidEmployeeController {
    
    @PostMapping("/validemployees")
    public ResponseEntity<ValidEmployee> saveEmplyeeData (@Valid @RequestBody ValidEmployee validEmployee) {
        return new ResponseEntity<ValidEmployee>(validEmployee, HttpStatus.CREATED);
    }
}
