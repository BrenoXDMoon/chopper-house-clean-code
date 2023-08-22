package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Idioma extends EntidadeDominio implements Serializable {
    private String nome;

    @ManyToMany
    private List<Jogo> jogos;
}
