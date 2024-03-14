package org.txor.pokemonhackingsession.service;

import lombok.RequiredArgsConstructor;
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

    public List<Pokemon> getHeaviest() {
        return pokeApiClient.getAllPokemons()
                .results().stream()
                .map(pokemon -> pokeApiClient.getPokemon(pokemon.url()))
                .sorted()
                .limit(5)
                .toList()
                ;
    }
}
