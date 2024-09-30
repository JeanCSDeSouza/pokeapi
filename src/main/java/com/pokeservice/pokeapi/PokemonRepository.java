package com.pokeservice.pokeapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    boolean existsByNome(String nome);
    Optional<Pokemon> findByNome(String nome);
}
