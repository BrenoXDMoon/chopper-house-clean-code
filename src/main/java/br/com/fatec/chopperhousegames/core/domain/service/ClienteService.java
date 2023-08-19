package br.com.fatec.chopperhousegames.core.domain.service;

import br.com.fatec.chopperhousegames.core.domain.entity.Cliente;
import br.com.fatec.chopperhousegames.core.domain.entity.Senha;
import br.com.fatec.chopperhousegames.inbound.facade.dto.CadastroClienteCommand;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente salvar(CadastroClienteCommand cadastroClienteCommand);

    Cliente editar(Cliente cliente);

    void excluir(Long id);

    List<Cliente> listar();

    Optional<Cliente> buscarPorEmail(String email);

    Cliente buscarPorId(Long id);

    Cliente editarSenha(Cliente cliente, Senha senha);

    Cliente ativaInativa(Long id);
}
