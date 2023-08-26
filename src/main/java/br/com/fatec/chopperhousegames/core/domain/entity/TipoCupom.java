package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum TipoCupom implements Serializable {

    DESCONTO("DESCONTO"),
    TROCA("TROCA"),
    ZERADO("ZERADO");

    private final String nome;
}