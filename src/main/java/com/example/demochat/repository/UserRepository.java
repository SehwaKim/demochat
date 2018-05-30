package com.example.demochat.repository;

import com.example.demochat.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findUsersByEmail(String email);
}
