package org.txor.pokemonhackingsession.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.txor.pokemonhackingsession.client.PokeApiClient;
import org.txor.pokemonhackingsession.model.Pokemon;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeaviestService {

    private final PokeApiClient pokeApiClient;

    @SneakyThrows
    public List<Pokemon> getHeaviest() {
        return pokeApiClient.getAllPokemons().toFuture().get()
                .results()
                .parallelStream()
                .map(pokemon -> {
                    try {
                        Thread.sleep(getMillis());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return pokeApiClient.getPokemon(pokemon.url());
                })
                .sorted((o1, o2) -> o2.weight() - o1.weight())
                .limit(5)
                .toList();
    }

    private static long getMillis() {
        return Math.round(Math.random() * 100);
    }
}
