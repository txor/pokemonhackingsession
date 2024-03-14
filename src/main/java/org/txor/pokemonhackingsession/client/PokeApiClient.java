package org.txor.pokemonhackingsession.client;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.txor.pokemonhackingsession.model.Pokemon;
import org.txor.pokemonhackingsession.model.Pokemons;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PokeApiClient {

    private final WebClient webClient;

    @SneakyThrows
    public Pokemon getPokemon(String url) {
        log.info("Get {}", url);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Pokemon.class).toFuture().get();
    }

    @SneakyThrows
    public Pokemons getAllPokemons() {
        return webClient
                .get()
                .uri("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=100000")
                .retrieve()
                .bodyToMono(Pokemons.class)
                .toFuture()
                .get();
    }
}
