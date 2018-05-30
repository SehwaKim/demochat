package com.example.demochat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChannelController {
    @GetMapping("/")
    public String main(){

        return "channels/main";
    }

    @GetMapping("/greeting")
    public String greeting(){

        return "channels/greeting";
    }
}
