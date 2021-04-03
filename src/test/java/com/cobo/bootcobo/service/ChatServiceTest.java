package com.cobo.bootcobo.service;


import com.cobo.bootcobo.entity.Chat;
import com.cobo.bootcobo.impl.ChatImpl;
import com.cobo.bootcobo.model.request.ChatMessageReq;
import com.cobo.bootcobo.repo.ChatRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class ChatServiceTest {
    @Mock
    private ChatRepo chatRepo;
    @InjectMocks
    private ChatImpl chatService;


    @Test
    void testGetAllChatSuccess(){
        Chat chat = new Chat();
        chat.setId("1");
        Chat chat1 = new Chat();
        chat.setId("2");
        List<Chat> chats = new ArrayList<>();
        chats.add(chat);
        chats.add(chat1);

        Mockito.when(chatRepo.findAll()).thenReturn(chats );

        List<Chat> chatList = chatService.getAll();
        Assertions.assertEquals(2,chatList.size());

    }

    @Test
    void testAddChatSuccess(){
        ChatMessageReq chatMessageReq = new ChatMessageReq();
        chatMessageReq.setSender("1");
        chatMessageReq.setMessages("pesan");
        chatMessageReq.setRoomId("2");
        Chat chat = chatService.add(chatMessageReq);

        Assertions.assertNotNull(chat );
        Assertions.assertEquals("1",chat.getSender() );
        Assertions.assertEquals("pesan",chat.getMessages() );
        Assertions.assertEquals("2",chat.getRoomId() );
    }

}
