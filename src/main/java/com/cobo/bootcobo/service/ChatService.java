package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.Chat;
import com.cobo.bootcobo.entity.Comment;
import com.cobo.bootcobo.model.request.ChatMessageReq;

import java.util.List;

public interface ChatService {
    List<Chat> getAll();
    Chat add(ChatMessageReq chatMessageReq);

}
