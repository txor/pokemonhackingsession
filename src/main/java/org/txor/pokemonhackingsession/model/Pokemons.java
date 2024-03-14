package org.txor.pokemonhackingsession.model;

import java.util.List;

public record Pokemons(List<PokemonReference> results) {
    public record PokemonReference(String name, String url) {

    }
}