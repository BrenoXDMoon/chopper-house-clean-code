package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum Idioma implements Serializable {

    INGLES("ENG"),
    PORTUGUES("PT-BR"),
    ESPANHOL("ESP"),
    JAPONES("JP"),
    FRANCES("FRA"),
    MANDARIM("CHI"),
    ITALIANO("ITA"),
    RUSSO("RUS");

    private String nome;
}
