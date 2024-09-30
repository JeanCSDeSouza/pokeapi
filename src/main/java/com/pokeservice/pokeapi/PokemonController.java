package com.pokeservice.pokeapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pokemon")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> getPokemons() {
        List<Pokemon> pokemons = pokemonService.getAllPokemons();
        if (pokemons.isEmpty()) {
            return ResponseEntity.status(404).body(new ArrayList<>());
        } else {
            return ResponseEntity.ok(pokemons);
        }
    }
    @PostMapping
    public ResponseEntity<Object> addPokemon(@RequestBody PokemonDto pokemonDto) {
        try {
            Pokemon newPokemon = pokemonService.addPokemon(pokemonDto);
            return ResponseEntity.status(201).body(newPokemon);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body("Pokemon with the same name already exists");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Could not add pokemon");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable("id") Integer id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
        return pokemon.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(Pokemon.builder().build()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") Integer id) {
        try {
            boolean isDeleted = pokemonService.deletePokemon(id);
            if (isDeleted) {
                return ResponseEntity.ok("Pokemon deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not delete the Pokemon");
        }
    }

    // Atualizar o treinador de um Pokémon por ID
    @PutMapping("/{id}/treinador")
    public ResponseEntity<Pokemon> updatePokemonTrainer(@PathVariable("id") Integer id, @RequestBody String novoTreinador) {
        try {
            Optional<Pokemon> updatedPokemon = pokemonService.updatePokemonTrainer(id, novoTreinador);
            return updatedPokemon.map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(Pokemon.builder().build()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Pokemon.builder().build());
        }
    }
}
