package br.com.fatec.chopperhousegames.core.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends EntidadeDominio implements Serializable {

    private String nomeCompleto;

    @Column(unique = true)
    private String email;

    private String dataNascimento;

    private String senha;
    
    private String cpf;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartaoCredito> cartoes;

    private TipoCliente tipoCliente;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    private Carrinho carrinho;

    @OneToMany(mappedBy = "cliente", targetEntity = Pedido.class)
    private List<Pedido> pedidos;
}