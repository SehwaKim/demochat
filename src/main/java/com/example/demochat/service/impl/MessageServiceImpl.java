package com.example.demochat.service.impl;

import com.example.demochat.domain.Message;
import com.example.demochat.repository.MessageRepository;
import com.example.demochat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByChannelId(Long channelId) {
        return messageRepository.findAllByChannelId(channelId);
    }
}
