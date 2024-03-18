package org.txor.pokemonhackingsession.service;

import org.junit.jupiter.api.Test;
import org.txor.pokemonhackingsession.client.PokeApiClient;
import org.txor.pokemonhackingsession.model.Pokemon;
import org.txor.pokemonhackingsession.model.Pokemons;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HeaviestServiceTest {

    @Test
    void getSortedPokemons() {
        // given
        PokeApiClient heaviestClient = mock(PokeApiClient.class);
        when(heaviestClient.getAllPokemons()).thenReturn(Mono.just(new Pokemons(
                List.of(
                        new Pokemons.PokemonReference("lolo", "url"),
                        new Pokemons.PokemonReference("lele", "url")
                ))));
        when(heaviestClient.getPokemon("url"))
                .thenReturn(new Pokemon("lolo", 40))
                .thenReturn(new Pokemon("lele", 50))
        ;
        HeaviestService heaviestService = new HeaviestService(heaviestClient);

        // then
        List<Pokemon> pokemon = heaviestService.getHeaviest();

        // when
        verify(heaviestClient).getAllPokemons();
        verify(heaviestClient, times(2)).getPokemon("url");
        assertEquals(new Pokemon("lele", 50), pokemon.get(0));
        assertEquals(new Pokemon("lolo", 40), pokemon.get(1));
    }
}