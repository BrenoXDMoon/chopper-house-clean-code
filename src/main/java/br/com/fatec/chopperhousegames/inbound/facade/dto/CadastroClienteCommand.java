package br.com.fatec.chopperhousegames.inbound.facade.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Data
public class CadastroClienteCommand {

    @NotEmpty(message = "Nome Completo é obrigatório!")
    private String nome;

    @NotEmpty(message = "Email é obrigatório!")
    private String email;

    @NotEmpty(message = "Data de Nascimento é obrigatório!")
    private String dataNascimento;

    @NotEmpty(message = "Telefone é obrigatório!")
    private String telefone;

    @NotEmpty(message = "CPF é obrigatório!")
    @CPF(message = "CPF Inválido!")
    private String cpf;

    @NotEmpty(message = "Senha é obrigatória!")
    private String senha;

}
