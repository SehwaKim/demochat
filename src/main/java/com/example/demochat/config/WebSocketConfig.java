package com.example.demochat.config;

import com.example.demochat.interceptor.HttpSessionIdHandshakeInterceptor;
import com.example.demochat.websocket.RawWebSocketHandler;
import com.example.demochat.websocket.CustomWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private CustomWebSocketHandler customWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new RawWebSocketHandler(), "/raw");
        registry.addHandler(customWebSocketHandler, "/sock").withSockJS().setInterceptors(new HttpSessionIdHandshakeInterceptor());
    }
}
