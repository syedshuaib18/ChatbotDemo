package com.chatbot.demo.controller;

import com.chatbot.demo.dto.MessageRequest;
import com.chatbot.demo.service.ChatService;
import com.chatbot.demo.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebhookController {

    private final ChatService chatService;
    private final AIService aiService;

    public WebhookController(ChatService chatService, AIService aiService) {
        this.chatService = chatService;
        this.aiService = aiService;
    }

    @PostMapping("/webhook")
    public String receiveMessage(@RequestBody MessageRequest request) {

        String message = request.getMessage();

        // Rule-based responses
        if (message.equalsIgnoreCase("hi") || message.equalsIgnoreCase("bye")) {
            return chatService.getReply(message);
        }

        // AI response for other messages
        return aiService.getAIResponse(message);
    }
}