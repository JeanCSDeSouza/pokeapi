package com.pokeservice.pokeapi;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonDto {
    private String nome;
    private String descricao;
    private double valor;
    private LocalDateTime tempo;
    private String usuario;
    private String imagem;
}
