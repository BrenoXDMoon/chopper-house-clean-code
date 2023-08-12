package br.com.fatec.chopperhousegames.inbound.facade;


import br.com.fatec.chopperhousegames.inbound.facade.dto.CadastroClienteCommand;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;
import br.com.fatec.chopperhousegames.inbound.facade.dto.SenhaDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteFacade extends Facade {

    ClienteDTO salvar(CadastroClienteCommand ent);

    ClienteDTO editar(ClienteDTO ent);

    ClienteDTO excluir(ClienteDTO ent);

    void ativaInativa(Long id);

    List<ClienteDTO> listar();

    ClienteDTO buscarPorId(Long id);

    Optional<ClienteDTO> buscarPorEmail(String email);

    ClienteDTO atualUsuarioLogado();

    Boolean usuarioEstaLogado(Long id);

    ClienteDTO editarSenha(ClienteDTO clienteDTO, SenhaDTO dto);
}
