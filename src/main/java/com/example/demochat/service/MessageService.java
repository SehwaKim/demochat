package com.example.demochat.service;

import com.example.demochat.domain.Message;

import java.util.List;

public interface MessageService {
    public Message addMessage(Message message);
    public List<Message> getMessagesByChannelId(Long channelId);
}
