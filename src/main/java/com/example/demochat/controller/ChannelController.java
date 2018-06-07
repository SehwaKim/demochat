package com.example.demochat.controller;

import com.example.demochat.domain.Channel;
import com.example.demochat.security.LoginUserInfo;
import com.example.demochat.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @GetMapping("/")
    public String channels(Principal principal, ModelMap modelMap){
        List<Channel> channels = new ArrayList<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof LoginUserInfo){
            LoginUserInfo loginUserInfo = (LoginUserInfo) authentication.getPrincipal();
            channels = channelService.getChannels(loginUserInfo.getId());
        }

        modelMap.addAttribute("list", channels);

        return "channels/channels";
    }

    @GetMapping("/main")
    public String main(){

        return "channels/main";
    }

    @GetMapping("/greeting")
    public String greeting(){

        return "channels/greeting";
    }
}
