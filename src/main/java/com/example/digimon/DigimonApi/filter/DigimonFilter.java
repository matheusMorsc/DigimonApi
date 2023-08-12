package com.example.digimon.DigimonApi.filter;

import com.example.digimon.DigimonApi.model.Digimon;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
//Componente de filtro para manipular as informações
@Component
public class DigimonFilter {

    public Flux<Digimon> filterDigimons(Flux<Digimon> digimons, String nameFilter, String levelFilter) {
        if (nameFilter != null) {
            digimons = digimons.filter(digimon -> digimon.getName().contains(nameFilter));
        }

        if (levelFilter != null) {
            digimons = digimons.filter(digimon -> digimon.getLevel().equals(levelFilter));
        }

        return digimons;
    }
}