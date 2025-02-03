package com.braymond.demo.service;

import com.braymond.demo.model.Poem;
import com.braymond.demo.model.PoemAnalysis;
import org.springframework.stereotype.Service;

@Service
public class PoemService {

    public PoemAnalysis analyzePoem(Poem poem) {
        //CALL LLM API

        PoemAnalysis analysis = new PoemAnalysis();
        analysis.setData("Poem analysis here");

        return analysis;
    }
}
