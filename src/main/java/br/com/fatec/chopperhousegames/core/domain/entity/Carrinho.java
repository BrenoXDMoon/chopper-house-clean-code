package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Carrinho extends EntidadeDominio implements Serializable {

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
}
