package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Jogo extends EntidadeDominio implements Serializable {

    private String titulo;

    private Double preco;

    private boolean multijogador;

    private String faixaEtaria;

    private String sinopse;

    private String imagem;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

    @Enumerated(EnumType.ORDINAL)
    private Plataforma plataforma;

    private Idioma idiomas;

    private Genero generos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "editora_id")
    private Editora editora;

    private boolean ativo;

    private Integer quantidade;

    private Integer quantidadeDisponivel;

    private String motivoInativacao;
}
