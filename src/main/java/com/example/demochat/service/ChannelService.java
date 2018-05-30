package com.example.demochat.service;

import com.example.demochat.domain.Channel;

public interface ChannelService {
    public Channel getChannel(Long channelId);

    public void addChannel(Channel channel);
}
