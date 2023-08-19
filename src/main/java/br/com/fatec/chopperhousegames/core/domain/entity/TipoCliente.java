package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoCliente {
    CLIENTE("CLIENTE"), ADMINISTRADOR("ADMIN");

    private final String role;

    public String getRole() {
        return role;
    }
}
