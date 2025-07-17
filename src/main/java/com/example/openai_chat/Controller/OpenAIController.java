package com.example.openai_chat.Controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OpenAIController {

    private OpenAiChatModel chatModel;

    public OpenAIController(OpenAiChatModel chatModel){
        this.chatModel = chatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatModel.call(message);
        return ResponseEntity.ok(response);
    }
}
