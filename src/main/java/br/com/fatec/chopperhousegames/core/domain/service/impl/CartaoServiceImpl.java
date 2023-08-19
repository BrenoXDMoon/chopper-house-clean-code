package br.com.fatec.chopperhousegames.core.domain.service.impl;

import br.com.fatec.chopperhousegames.core.domain.DomainException;
import br.com.fatec.chopperhousegames.core.domain.entity.CartaoCredito;
import br.com.fatec.chopperhousegames.core.domain.service.CartaoService;
import br.com.fatec.chopperhousegames.core.repository.CartaoCreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoServiceImpl implements CartaoService {


    private final CartaoCreditoRepository repository;

    public CartaoServiceImpl(CartaoCreditoRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartaoCredito buscaCartaoPorId(Long id) {
        return repository.findById(id).orElseThrow(DomainException::ch001RegistroNaoEncontrado);
    }


    @Override
    public List<CartaoCredito> buscaTodosCartoes() {
        return repository.findAll();
    }

    @Override
    public CartaoCredito registraCartao(CartaoCredito cartao) {
        //TODO: REFATORAR FLUXO PARA ATRIBUIR CLIENTE AO CARTÃO
        //cartao.setCliente(clienteService.atualUsuarioLogado());
        return repository.save(cartao);
    }

    @Override
    public Void removeCartao(Long id) {
        repository.delete(buscaCartaoPorId(id));
        return null;
    }

    @Override
    public CartaoCredito alteraCartao(CartaoCredito cartao) {
        //TODO: REFATORAR FLUXO PARA ATRIBUIR CLIENTE AO CARTÃO
        //cartao.setCliente(clienteService.atualUsuarioLogado());
        return repository.save(cartao);
    }
}
