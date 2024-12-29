package com.chatserver.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class WebRtc_WebSocketConfig implements WebSocketMessageBrokerConfigurer{
   
   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry){
      /*
      서버로 보내는 메시지 (클라이언트 -> 서버):
      클라이언트가 /app/chat로 메시지를 보내면, 서버의 @MessageMapping("/chat") 메서드가 이 메시지를 처리합니다.

      서버에서 보내는 메시지 (서버 -> 클라이언트):
      서버에서 /topic/greetings와 같은 경로로 메시지를 발행하면, 클라이언트가 이 경로를 구독하고 있으면 해당 메시지를 수신합니다.
       
      tooic과 app는 실제 존재하는 페이지 url이 아니라 "서버 측" 또는 "클라이언트 측"이란 의미의 대명사같은 주소.

      클라이언트 jsp페이지에서 /topic/... 이나 /app/..로 보내면 EnableWebSocketMessageBroker가 알아서 처리
      */
      registry.enableSimpleBroker("/topic");
      registry.setApplicationDestinationPrefixes("/app");
   }

   @Override
   public void registerStompEndpoints(StompEndpointRegistry registry){
      
      System.out.println("registerStompEndpoints");
      registry
         .addEndpoint("/chat")
         .setAllowedOriginPatterns("*")
         .withSockJS();

         /* .setAllowedOrigins("http://localhost:80", "http://127.0.0.1:80","https://localhost:80", "https://127.0.0.1:80","http://webrtcpj.o-r.kr","https://webrtcpj.o-r.kr","http://awsonly2024.github.io","https://awsonly2024.github.io","http://43.201.71.202","https://43.201.71.202","http://chatserverpj.o-r.kr","https://chatserverpj.o-r.kr") */
   }
}
