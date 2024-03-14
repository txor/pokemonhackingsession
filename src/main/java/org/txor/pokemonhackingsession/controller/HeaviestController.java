package org.txor.pokemonhackingsession.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.txor.pokemonhackingsession.model.Pokemon;
import org.txor.pokemonhackingsession.service.HeaviestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HeaviestController {

    private final HeaviestService heaviestService;

    @GetMapping("/heaviest")
    public List<String> getHeaviest() {
        return heaviestService.getHeaviest()
                .stream()
                .map(Pokemon::name)
                .toList();
    }
}
