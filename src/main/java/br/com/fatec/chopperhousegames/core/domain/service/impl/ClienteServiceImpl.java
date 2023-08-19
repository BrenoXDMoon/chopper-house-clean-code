package br.com.fatec.chopperhousegames.core.domain.service.impl;

import br.com.fatec.chopperhousegames.core.domain.entity.Cliente;
import br.com.fatec.chopperhousegames.core.domain.entity.Senha;
import br.com.fatec.chopperhousegames.core.domain.entity.TipoCliente;
import br.com.fatec.chopperhousegames.core.domain.service.ClienteService;
import br.com.fatec.chopperhousegames.core.repository.ClienteRepository;
import br.com.fatec.chopperhousegames.inbound.facade.dto.CadastroClienteCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salvar(CadastroClienteCommand cadastroClienteCommand) {
        Cliente cliente = new Cliente();
        cliente.setTipoCliente(TipoCliente.CLIENTE);
        return repository.saveAndFlush(cliente);
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return repository.saveAndFlush(cliente);
    }

    @Override
    public void excluir(Long id) {
        repository.inativaClientePorId(id);
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return repository.findByEmail(email);

    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(new Cliente());
    }

    @Override
    public Cliente editarSenha(Cliente cliente, Senha senha) {
        //TODO: mover para este método a validação de senha
        cliente.setSenha(senha.getSenha());
        return editar(cliente);
    }

    @Override
    public Cliente ativaInativa(Long id) {

        Cliente cliente = buscarPorId(id);
        if (cliente.getId() != null) {
            cliente.setAtivo(!cliente.isAtivo());
        }

        return editar(cliente);
    }
}
