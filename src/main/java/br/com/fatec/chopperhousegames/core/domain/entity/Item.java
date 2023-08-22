package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
public class Item extends EntidadeDominio implements Serializable {

    @ManyToOne
    private Jogo jogo;
    private Integer quantidade;
    private Integer quantidadeTroca;

}
