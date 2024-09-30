package com.pokeservice.pokeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class PokemonDataInitializer implements CommandLineRunner {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criar três Pokémons
        Pokemon pikachu = Pokemon.builder()
                .nome("Pikachu")
                .descricao("Um Pokémon elétrico conhecido por suas bochechas que soltam faíscas.")
                .valor(500.0)
                .tempo(LocalDateTime.now()) // Definindo o tempo como o momento atual
                .usuario("Ash")
                .imagem("https://img.pokemondb.net/sprites/scarlet-violet/normal/pikachu.png\"")
                .build();

        Pokemon charmander = Pokemon.builder()
                .nome("Charmander")
                .descricao("Um Pokémon de fogo pequeno e corajoso, sua cauda está sempre em chamas.")
                .valor(300.0)
                .tempo(LocalDateTime.now()) // Definindo o tempo como o momento atual
                .usuario("Brock")
                .imagem("https://img.pokemondb.net/sprites/scarlet-violet/normal/charmander.png")
                .build();
        System.out.println(LocalDateTime.now() +" DATA AGORA");
        Pokemon bulbasaur = Pokemon.builder()
                .nome("Bulbasaur")
                .descricao("Um Pokémon de grama com uma planta crescendo em suas costas.")
                .valor(400.0)
                .tempo(LocalDateTime.now()) // Definindo o tempo como o momento atual
                .usuario("Misty")
                .imagem("https://img.pokemondb.net/sprites/scarlet-violet/normal/bulbasaur.png")
                .build();
        // Verificar se cada Pokémon já está no banco de dados, e se não estiver, inseri-los
        Arrays.asList(pikachu, charmander, bulbasaur).forEach(this::inserirSeNaoExistir);
    }

    private void inserirSeNaoExistir(Pokemon pokemon) {
        // Verificar se o Pokémon já existe no banco de dados
        if (pokemonRepository.findByNome(pokemon.getNome()).isEmpty()) {
            // Inserir o Pokémon no banco de dados
            pokemonRepository.save(pokemon);
            System.out.println(pokemon.getNome() + " inserido no banco de dados.");
        } else {
            System.out.println(pokemon.getNome() + " já existe no banco de dados.");
        }
    }
}

