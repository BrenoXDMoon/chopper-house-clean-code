package br.com.fatec.chopperhousegames.core.domain.service.impl;

import br.com.fatec.chopperhousegames.core.domain.exception.DomainException;
import br.com.fatec.chopperhousegames.core.domain.entity.Endereco;
import br.com.fatec.chopperhousegames.core.domain.service.EnderecoService;
import br.com.fatec.chopperhousegames.outbound.repository.jpa.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoServiceImpl(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Endereco buscaEnderecoPorId(Long id) {
        return repository.findById(id).orElseThrow(DomainException::ch001RegistroNaoEncontrado);
    }

    @Override
    public Endereco registraEndereco(Endereco end) {
        return repository.save(end);
    }

    @Override
    public void removeEndereco(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Endereco alteraEndereco(Endereco endereco) {
        return repository.save(endereco);
    }

    @Override
    public List<Endereco> buscarTodosEnderecos() {
        return repository.findAll();
    }
}
