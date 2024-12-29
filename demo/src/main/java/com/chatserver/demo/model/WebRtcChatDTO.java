package com.chatserver.demo.model;

public class WebRtcChatDTO {
   private String sender;
   private String contents;

   public WebRtcChatDTO() {
   }

   public WebRtcChatDTO(String sender, String contents){
      this.sender = sender;
      this.contents = contents;
   }

   public String getSender() {
      return this.sender;
   }

   public void setSender(String sender) {
      this.sender = sender;
   }

   public String getContents() {
      return this.contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }
}
