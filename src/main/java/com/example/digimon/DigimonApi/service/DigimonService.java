package com.example.digimon.DigimonApi.service;

import com.example.digimon.DigimonApi.model.Digimon;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class DigimonService {

    private final WebClient webClient;
    //O Service que realiza a conexão com a Api de Digimon
    public DigimonService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://digimon-api.vercel.app/api/digimon").build();
    }
    //Service que constrói o método de filtragem, esse exibindo a lista completa
    public Flux<Digimon> listDigimons(String nameFilter, String levelFilter) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("name", nameFilter)
                        .queryParam("level", levelFilter)
                        .build())
                .retrieve()
                .bodyToFlux(Digimon.class);
    }
    //Apenas por nome
    public Flux<Digimon> listDigimonsByName(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToFlux(Digimon.class);
    }
    //Apenas por level
    public Flux<Digimon> listDigimonsByLevel(String level) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("level", level)
                        .build())
                .retrieve()
                .bodyToFlux(Digimon.class);
    }
}