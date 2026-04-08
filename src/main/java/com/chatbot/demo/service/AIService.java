package com.chatbot.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;

@Service
public class AIService {

    private final String API_KEY = "ff6b0491-2456-4393-b28a-ea7aec044956";

    // ✅ SAMBANOVA URL
    private final String API_URL = "https://api.sambanova.ai/v1/chat/completions";

    public String getAIResponse(String message) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + API_KEY);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> body = new HashMap<>();

            // ✅ IMPORTANT: Use SambaNova model
            body.put("model", "Meta-Llama-3.3-70B-Instruct");

            List<Map<String, String>> messages = new ArrayList<>();
            messages.add(Map.of("role", "user", "content", message));

            body.put("messages", messages);

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(body, headers);

            // ✅ FIXED API CALL
            ResponseEntity<Map> response =
                    restTemplate.postForEntity(API_URL, request, Map.class);

            if (response.getBody() == null) {
                return "No response from AI";
            }

            List<?> choices = (List<?>) response.getBody().get("choices");

            if (choices == null || choices.isEmpty()) {
                return "Invalid AI response";
            }

            Map<?, ?> choice = (Map<?, ?>) choices.get(0);
            Map<?, ?> messageMap = (Map<?, ?>) choice.get("message");

            return messageMap.get("content").toString();

        } catch (Exception e) {
            return "AI fallback: " + message;
        }
    }
}