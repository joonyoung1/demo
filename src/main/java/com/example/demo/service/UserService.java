package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;

public interface UserService {
    
    public User createUser(User user);
    public UserDto getUser(int userId);
}
