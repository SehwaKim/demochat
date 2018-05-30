package com.example.demochat.service;

import com.example.demochat.domain.User;

public interface UserService {
    public void addUser(User user);

    public User getUserByEmail(String email);
}
