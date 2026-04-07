package com.chatbot.demo.controller;

import com.chatbot.demo.dto.MessageRequest;
import com.chatbot.demo.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebhookController {

    private final ChatService chatService;

    public WebhookController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/webhook")
    public String receiveMessage(@RequestBody MessageRequest request) {
        return chatService.getReply(request.getMessage());
    }
}