package com.example.demochat.repository;

import com.example.demochat.domain.ChannelUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelUserRepository extends JpaRepository<ChannelUser, Long> {
    ChannelUser findChannelUserByChannelIdAndUserId(Long channelId, Long userId);
}
