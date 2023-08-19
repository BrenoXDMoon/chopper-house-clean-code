package br.com.fatec.chopperhousegames.inbound.facade;

import br.com.fatec.chopperhousegames.inbound.facade.dto.CartaoCreditoDTO;

import java.util.List;

public interface CartaoFacade {
    List<CartaoCreditoDTO> buscaTodosCartoes();

    CartaoCreditoDTO registraCartao(CartaoCreditoDTO dto);

    Void removeCartao(Long id);

    CartaoCreditoDTO buscaCartaoPorId(Long id);

    CartaoCreditoDTO alteraCartao(CartaoCreditoDTO cartaoDto);
}
