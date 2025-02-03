package com.braymond.demo.apiclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

@Component
public class ChatClient {

    private final WebClient webClient;

    public ChatClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.example.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public String getData() {
        return webClient.get()
                .uri("/data")
                .retrieve()
                .bodyToMono(String.class)
                .block();  // Blocking call for synchronous execution
    }

    public Mono<String> sendData(Object requestData) {
        return webClient.post()
                .uri("/data")  // Set the endpoint
                .body(BodyInserters.fromValue(requestData))  // Add the request body
                .retrieve()  // Send the request
                .bodyToMono(String.class);  // Convert the response to a String (you can use other types here)
    }
}
