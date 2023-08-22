package br.com.fatec.chopperhousegames.inbound.facade;

import br.com.fatec.chopperhousegames.inbound.facade.dto.EnderecoDTO;

import java.util.List;

public interface EnderecoFacade {
    
    
    EnderecoDTO registraEndereco(EnderecoDTO enderecoDto);

    Void removeEndereco(Long id);

    EnderecoDTO buscaEnderecoPorId(Long id);

    EnderecoDTO alteraDadosEndereco(EnderecoDTO enderecoForm);

    List<EnderecoDTO> buscaTodosEnderecos();
}
