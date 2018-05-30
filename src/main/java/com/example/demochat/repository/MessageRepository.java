package com.example.demochat.repository;

import com.example.demochat.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChannelId(Long channelId);
}
