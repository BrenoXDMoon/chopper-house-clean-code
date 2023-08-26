package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public enum Plataforma implements Serializable {

    PS4("PlayStation 4"),
    NINTENDO_SWITCH("Nintendo Switch"),
    PC("PC"),
    XBOX_ONE("XBox One"),
    PS3("PlayStation 3"),
    XBOX_360("XBox 360"),
    WII("Nintendo Wii");

    private String nome;

}
