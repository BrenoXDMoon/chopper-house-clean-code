package br.com.fatec.chopperhousegames.inbound.facade.dto;

import br.com.fatec.chopperhousegames.core.domain.entity.TipoCliente;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class ClienteDTO extends EntidadeDTO {

    private Long id;

    private String nomeCompleto;

    private String email;

    private String dataNascimento;

    private String telefone;

    private String cpf;

    private String senha;

    private String confirmaSenha;

    private TipoCliente tipoCliente;

    private List<CartaoCreditoDTO> cartoes;

    private List<EnderecoDTO> enderecos;

    private Boolean ativo;

}
