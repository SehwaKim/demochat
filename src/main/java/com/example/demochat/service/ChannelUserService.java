package com.example.demochat.service;

import com.example.demochat.domain.ChannelUser;

import java.util.List;

public interface ChannelUserService {
    public void addChannelUser(ChannelUser channelUser);

    public ChannelUser getChannelUser(Long channelId, Long userId);

    List<ChannelUser> getChannelUsersByUserId(Long userId);
}
