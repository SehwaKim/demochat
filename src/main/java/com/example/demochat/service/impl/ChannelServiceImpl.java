package com.example.demochat.service.impl;

import com.example.demochat.domain.Channel;
import com.example.demochat.domain.ChannelUser;
import com.example.demochat.repository.ChannelRepository;
import com.example.demochat.repository.ChannelUserRepository;
import com.example.demochat.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    ChannelUserRepository channelUserRepository;

    @Override
    public List<Channel> getChannels(Long userId) {
        List<Channel> channels = new ArrayList<>();
        List<ChannelUser> channelUsers = channelUserRepository.findAllByUserId(userId);
        for(ChannelUser channelUser : channelUsers){
            channels.add(channelUser.getChannel());
        }
        return channels;
    }

    @Override
    public Channel getChannel(Long channelId) {
        return channelRepository.getOne(channelId);
    }

    @Override
    public void addChannel(Channel channel) {
        channelRepository.save(channel);
    }
}
