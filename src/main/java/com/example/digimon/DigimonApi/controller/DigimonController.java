package com.example.digimon.DigimonApi.controller;

import com.example.digimon.DigimonApi.filter.DigimonFilter;
import com.example.digimon.DigimonApi.model.Digimon;
import com.example.digimon.DigimonApi.service.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DigimonController {

    private final DigimonService digimonService;
    private final DigimonFilter digimonFilter;

    @Autowired
    public DigimonController(DigimonService digimonService, DigimonFilter digimonFilter) {
        this.digimonService = digimonService;
        this.digimonFilter = digimonFilter;
    }
    //Controller que realiza a função de mostrar uma lista de todos os digimons
    @GetMapping("/digimons")
    public Flux<Digimon> listDigimons() {
        return digimonFilter.filterDigimons(digimonService.listDigimons("", ""), null, null);
    }
    //Para acessar o digimon via level
    @GetMapping("/digimons-by-level/{level}")
    public Flux<Digimon> listDigimonsByLevel(@PathVariable String level) {
        return digimonFilter.filterDigimons(digimonService.listDigimonsByLevel(level), null, level);
    }
    //Para pesquisar digimon por nome
    @GetMapping("/digimons-by-name/{name}")
    public Flux<Digimon> listDigimonsByName(@PathVariable String name) {
        return digimonFilter.filterDigimons(digimonService.listDigimons("", ""), name, null);
    }


}
