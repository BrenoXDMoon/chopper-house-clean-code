package br.com.fatec.chopperhousegames.inbound.facade.impl;

import br.com.fatec.chopperhousegames.core.domain.service.CartaoService;
import br.com.fatec.chopperhousegames.inbound.facade.CartaoFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.CartaoCreditoDTO;
import br.com.fatec.chopperhousegames.inbound.facade.mapper.CartaoCreditoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartaoFacadeImpl implements CartaoFacade {

    private final CartaoService service;
    private final CartaoCreditoMapper mapper;

    public CartaoFacadeImpl(CartaoService service, CartaoCreditoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public List<CartaoCreditoDTO> buscaTodosCartoes() {
        return mapper.toCartaoCreditoDTOList(service.buscaTodosCartoes());
    }

    @Override
    public CartaoCreditoDTO registraCartao(CartaoCreditoDTO dto) {
        return mapper.toCartaoDTO(service.registraCartao(mapper.toCartao(dto)));
    }

    @Override
    public Void removeCartao(Long id) {
        return service.removeCartao(id);
    }

    @Override
    public CartaoCreditoDTO buscaCartaoPorId(Long id) {
        return mapper.toCartaoDTO(service.buscaCartaoPorId(id));
    }

    @Override
    public CartaoCreditoDTO alteraCartao(CartaoCreditoDTO cartaoDto) {
        return mapper.toCartaoDTO(service.alteraCartao(mapper.toCartao(cartaoDto)));
    }
}