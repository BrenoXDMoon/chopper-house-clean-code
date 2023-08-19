package br.com.fatec.chopperhousegames.inbound.facade;


import br.com.fatec.chopperhousegames.inbound.facade.dto.CadastroClienteCommand;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteFacade extends Facade {

    ClienteDTO registraCliente(CadastroClienteCommand cadastroClienteCommand);

    //TODO: alterar assinatura do método de ClienteDTO para EditarClienteCommand
    ClienteDTO alteraDadosCliente(ClienteDTO clienteDTO);

    void inativaCliente(Long id);

    void ativaCliente(Long id);

    List<ClienteDTO> buscaTodos();

    ClienteDTO buscarPorId(Long id);

    Optional<ClienteDTO> buscaPorEmail(String email);

}
