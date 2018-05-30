package com.example.demochat.config;

import com.example.demochat.websocket.RawWebSocketHandler;
import com.example.demochat.websocket.SockJSWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new RawWebSocketHandler(), "/raw");
        registry.addHandler(new SockJSWebSocketHandler(), "/sock").withSockJS();
    }
}
