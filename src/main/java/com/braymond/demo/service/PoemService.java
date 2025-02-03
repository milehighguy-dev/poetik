package com.braymond.demo.service;

import com.braymond.demo.apiclient.ChatClient;
import com.braymond.demo.model.Poem;
import com.braymond.demo.model.PoemAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoemService {

    ChatClient chatClient;

    @Autowired
    PoemService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public PoemAnalysis analyzePoem(Poem poem) {

        //CALL LLM API
        String chatFeedback = chatClient.sendData(poem).block();

        PoemAnalysis analysis = new PoemAnalysis();
        analysis.setData(chatFeedback);

        return analysis;
    }
}
