package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
public class Status extends EntidadeDominio implements Serializable {
    private String status;
}
