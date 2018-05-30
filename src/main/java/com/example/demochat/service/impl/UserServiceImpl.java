package com.example.demochat.service.impl;

import com.example.demochat.domain.User;
import com.example.demochat.repository.UserRepository;
import com.example.demochat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {

        return userRepository.findUsersByEmail(email);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
