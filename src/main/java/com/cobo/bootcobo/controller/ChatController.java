package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.entity.Chat;
import com.cobo.bootcobo.model.request.ChatMessageReq;
import com.cobo.bootcobo.model.response.ChatMessageResp;
import com.cobo.bootcobo.service.ChatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {


    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    @SendTo("/broker/message")
    public ChatMessageResp sendMessage(ChatMessageReq chatMessageReq){
        Chat chat = chatService.add(chatMessageReq);
        ChatMessageResp chatMessageResp = new ChatMessageResp();
        BeanUtils.copyProperties(chat,chatMessageResp);
        return chatMessageResp;
    }
}
