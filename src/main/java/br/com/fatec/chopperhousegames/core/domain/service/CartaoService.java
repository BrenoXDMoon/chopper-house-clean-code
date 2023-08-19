package br.com.fatec.chopperhousegames.core.domain.service;

import br.com.fatec.chopperhousegames.core.domain.entity.CartaoCredito;

import java.util.List;

public interface CartaoService {
    CartaoCredito buscaCartaoPorId(Long id);

    List<CartaoCredito> buscaTodosCartoes();

    CartaoCredito registraCartao(CartaoCredito cartao);

    Void removeCartao(Long id);

    CartaoCredito alteraCartao(CartaoCredito cartao);
}
