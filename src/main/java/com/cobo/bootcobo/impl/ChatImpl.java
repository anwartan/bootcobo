package com.cobo.bootcobo.impl;

import com.cobo.bootcobo.entity.Chat;
import com.cobo.bootcobo.entity.Comment;
import com.cobo.bootcobo.entity.Community;
import com.cobo.bootcobo.model.request.ChatMessageReq;
import com.cobo.bootcobo.repo.ChatRepo;
import com.cobo.bootcobo.service.ChatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ChatImpl implements ChatService {

    @Autowired
    private ChatRepo chatRepo;

    @Override
    public List<Chat> getAll() {
        return chatRepo.findAll();
    }

    @Override
    public Chat add(ChatMessageReq chatMessageReq) {
        Chat chat = new Chat();
        BeanUtils.copyProperties(chatMessageReq,chat);
        chat.setCreated_at(new Date());
        chat.setUpdated_at(chat.getCreated_at());
        chatRepo.save(chat);
        return chat;
    }


}
