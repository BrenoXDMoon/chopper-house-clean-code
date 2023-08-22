package br.com.fatec.chopperhousegames.inbound.facade.mapper;

import br.com.fatec.chopperhousegames.core.domain.entity.Endereco;
import br.com.fatec.chopperhousegames.inbound.facade.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    @Mapping(source = "cidade", target = "cidade.cidade")
    @Mapping(source = "estado", target = "cidade.estado.estado")
    Endereco toEndereco(EnderecoDTO dto);

    @Mapping(source = "cidade.cidade", target = "cidade")
    @Mapping(source = "cidade.estado.estado", target = "estado")
    EnderecoDTO toEnderecoDTO(Endereco domain);
}
