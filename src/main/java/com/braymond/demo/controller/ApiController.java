package com.braymond.demo.controller;

import com.braymond.demo.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.braymond.demo.model.Poem;
import com.braymond.demo.model.PoemAnalysis;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    PoemService poemService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/poem")
    public ResponseEntity<PoemAnalysis> submitPoem(@RequestBody Poem poem) {
        PoemAnalysis analysis = poemService.analyzePoem(poem);

        if (analysis == null || analysis.getData() == null || analysis.getData().isEmpty()) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(analysis);
    }

}