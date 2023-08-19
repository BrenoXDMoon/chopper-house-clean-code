package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class Cidade implements Serializable {
    private String cidade;
    @Embedded
    private Estado estado;
}
