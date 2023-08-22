package br.com.fatec.chopperhousegames.core.domain.service;

import br.com.fatec.chopperhousegames.core.domain.entity.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco buscaEnderecoPorId(Long id);
    Endereco registraEndereco(Endereco end);

    void removeEndereco(Long id);

    Endereco alteraEndereco(Endereco enderecoForm);

    List<Endereco> buscarTodosEnderecos();
}
