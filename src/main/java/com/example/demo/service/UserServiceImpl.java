package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        User userSavedToDB = this.userRepository.save(user);
        return userSavedToDB;
    }

    @Override
    public UserDto getUser(int userId) {
        User user = this.userRepository.getReferenceById(userId);
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
