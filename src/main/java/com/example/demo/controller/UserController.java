package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreated = this.userServiceImpl.createUser(user);
        return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int userId){
        UserDto userDto = this.userServiceImpl.getUser(userId);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
}
