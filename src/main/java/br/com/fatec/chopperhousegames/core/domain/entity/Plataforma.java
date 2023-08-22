package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plataforma extends EntidadeDominio implements Serializable {
    private String nome;

    @OneToMany(mappedBy = "plataforma", targetEntity = Jogo.class)
    private List<Jogo> jogo;
}
