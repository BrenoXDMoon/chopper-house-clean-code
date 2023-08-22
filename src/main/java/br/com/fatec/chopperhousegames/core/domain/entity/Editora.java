package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Editora extends EntidadeDominio implements Serializable {

    private String nome;
    @OneToMany(mappedBy = "editora", targetEntity = Jogo.class)
    private List<Jogo> jogos;
}
