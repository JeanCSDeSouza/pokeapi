package com.pokeservice.pokeapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }
    public Pokemon addPokemon(PokemonDto pokemonDto) {
        // Verifica se já existe um Pokémon com o mesmo nome
        if (pokemonRepository.existsByNome(pokemonDto.getNome())) {
            throw new IllegalArgumentException("Pokemon com o mesmo nome já existe");
        }

        // Cria o novo Pokémon e salva
        Pokemon newPokemon = Pokemon.builder()
                .nome(pokemonDto.getNome())
                .descricao(pokemonDto.getDescricao())
                .valor(pokemonDto.getValor())
                .tempo(pokemonDto.getTempo())
                .usuario(pokemonDto.getUsuario())
                .imagem(pokemonDto.getImagem())
                .build();
        return pokemonRepository.save(newPokemon);
    }

    public Optional<Pokemon> getPokemonById(Integer id) {
        return pokemonRepository.findById(id);
    }

    public boolean deletePokemon(Integer id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if (pokemon.isPresent()) {
            pokemonRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public Optional<Pokemon> updatePokemonTrainer(Integer id, String novoTreinador) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if (pokemonOptional.isPresent()) {
            Pokemon pokemon = pokemonOptional.get();
            pokemon.setUsuario(novoTreinador);
            pokemonRepository.save(pokemon);
            return Optional.of(pokemon);
        }
        return Optional.empty();
    }
}