package com.example.demochat.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "channel_user")
@Data
public class ChannelUser implements Serializable {
    public ChannelUser() {
        this.regdate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @Column(name = "is_operator")
    private Boolean isOperator;
    private LocalDateTime regdate;

    public void setUser(User user){
        this.user = user;
        if(!user.getChannelUsers().contains(this)){
            user.getChannelUsers().add(this);
        }
    }
}
