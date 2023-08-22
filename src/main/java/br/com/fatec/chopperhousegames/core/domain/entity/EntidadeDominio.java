package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class EntidadeDominio {
    //TODO: implementar tenant ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: para atribuir os campos dataCriacao e dataAlteracao, criar um org.hibernate.annotations.Filter
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private boolean ativo;

}
