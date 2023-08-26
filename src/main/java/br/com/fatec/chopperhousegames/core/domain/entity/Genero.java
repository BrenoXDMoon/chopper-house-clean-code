package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum Genero implements Serializable {

    AVENTURA("Aventura"),
    FPS("FPS"),
    CORRIDA("Corrida"),
    PUZZLE("Puzzle"),
    HORROR("Horror"),
    TERROR("Terror"),
    SIMULADOR("Simulador"),
    VISUAL_NOVEL("Visual Novel"),
    LUTA("Luta");

    private String nome;

}
