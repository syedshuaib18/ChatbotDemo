package com.chatbot.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public String getReply(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "Message cannot be empty";
        }

        switch (message.toLowerCase()) {
            case "hi":
                return "Hello 👋";
            case "bye":
                return "Goodbye 👋";
            case "how are you":
                return "I'm doing great!";
            default:
                return "I don't understand that.";
        }
    }
}