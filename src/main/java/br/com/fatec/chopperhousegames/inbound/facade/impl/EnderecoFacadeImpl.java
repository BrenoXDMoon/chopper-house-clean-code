package br.com.fatec.chopperhousegames.inbound.facade.impl;

import br.com.fatec.chopperhousegames.core.domain.service.EnderecoService;
import br.com.fatec.chopperhousegames.inbound.facade.EnderecoFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.EnderecoDTO;
import br.com.fatec.chopperhousegames.inbound.facade.mapper.EnderecoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnderecoFacadeImpl implements EnderecoFacade {
    private final EnderecoService enderecoService;

    private final EnderecoMapper enderecoMapper;


    public EnderecoFacadeImpl(EnderecoService enderecoService, EnderecoMapper enderecoMapper) {
        this.enderecoService = enderecoService;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public EnderecoDTO registraEndereco(EnderecoDTO enderecoDto) {
        return enderecoMapper.toEnderecoDTO(enderecoService.registraEndereco(enderecoMapper.toEndereco(enderecoDto)));
    }

    @Override
    public Void removeEndereco(Long id) {
        enderecoService.removeEndereco(id);
        return null;
    }

    @Override
    public EnderecoDTO buscaEnderecoPorId(Long id) {
        return enderecoMapper.toEnderecoDTO(enderecoService.buscaEnderecoPorId(id));
    }

    @Override
    public EnderecoDTO alteraDadosEndereco(EnderecoDTO enderecoDto) {
        return enderecoMapper.toEnderecoDTO(enderecoService.alteraEndereco(enderecoMapper.toEndereco(enderecoDto)));
    }

    @Override
    public List<EnderecoDTO> buscaTodosEnderecos() {
        return enderecoService.buscarTodosEnderecos().stream().map(enderecoMapper::toEnderecoDTO).toList();
    }
}
