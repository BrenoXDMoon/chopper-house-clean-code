package br.com.fatec.chopperhousegames.inbound.facade.mapper;

import br.com.fatec.chopperhousegames.core.domain.entity.Cliente;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CartaoCreditoMapper.class, EnderecoMapper.class})
public interface ClienteMapper {

    Cliente toCliente(ClienteDTO dto);

    ClienteDTO toClienteDTO(Cliente cliente);

    List<ClienteDTO> toListDTO(List<Cliente> listar);
}
