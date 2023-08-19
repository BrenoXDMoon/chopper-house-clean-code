package br.com.fatec.chopperhousegames.inbound.facade.impl;

import br.com.fatec.chopperhousegames.core.domain.service.ClienteService;
import br.com.fatec.chopperhousegames.inbound.facade.ClienteFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.CadastroClienteCommand;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;
import br.com.fatec.chopperhousegames.inbound.facade.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteFacadeImpl implements ClienteFacade {

    private final ClienteMapper mapper;
    private final ClienteService service;

    @Autowired
    public ClienteFacadeImpl(ClienteMapper mapper, ClienteService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @Override
    public ClienteDTO registraCliente(CadastroClienteCommand command) {
        return mapper.toClienteDTO(service.salvar(command));
    }

    @Override
    public ClienteDTO alteraDadosCliente(ClienteDTO dto) {
        return mapper.toClienteDTO(service.editar(mapper.toCliente(dto)));
    }

    @Override
    public void inativaCliente(Long id) {
        service.excluir(id);
    }

    @Override
    public void ativaCliente(Long id) {

        mapper.toClienteDTO(service.ativaInativa(id));
    }

    @Override
    public List<ClienteDTO> buscaTodos() {
        return mapper.toListDTO(service.listar());
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        return mapper.toClienteDTO(service.buscarPorId(id));
    }

    @Override
    public Optional<ClienteDTO> buscaPorEmail(String email) {
        return Optional.of(mapper.toClienteDTO(service.buscarPorEmail(email).orElse(null)));
    }

}
