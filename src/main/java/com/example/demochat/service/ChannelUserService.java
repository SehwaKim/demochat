package com.example.demochat.service;

import com.example.demochat.domain.ChannelUser;

public interface ChannelUserService {
    public void addChannelUser(ChannelUser channelUser);

    public ChannelUser getChannelUser(Long channelId, Long userId);

}
