package com.chatserver.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.chatserver.demo.model.WebRtcChatDTO;

@Controller
public class WebRtcChatController {
   /*
   @MessageMapping은 HTTP 요청에서 @RequestMapping과 유사하지만, WebSocket을 통해 들어오는 메시지를 처리합니다. 
   MessageMapping 받아서 SendTo로 보낸다
   */

   //클라이언트가 보낸 message이기 때문에 앞에 app가 생략된 것. 클라이언트가 app/sendMessage" 경로로 메시지를 보내면 알아서 처리
   @MessageMapping("/sendMessage")  //클라이언트로부터 받는 맵핑주소
   @SendTo("/topic/messages") //컨트롤러에서 클라이언트로 전송하는 맵핑주소
   public WebRtcChatDTO sendMessage(WebRtcChatDTO message){
      System.out.println("controller message:" + message);
      System.out.println("sendMessage Controller");
      return message;
   } 
}
