package com.pokeservice.pokeapi;

import java.util.List;

public class PokemonResponse {
    private String message;
    private List<Pokemon> pokemons;

    public PokemonResponse(String message, List<Pokemon> pokemons) {
        this.message = message;
        this.pokemons = pokemons;
    }
}
