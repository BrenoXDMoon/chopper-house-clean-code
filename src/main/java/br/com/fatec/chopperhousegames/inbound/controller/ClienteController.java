package br.com.fatec.chopperhousegames.inbound.controller;

import br.com.fatec.chopperhousegames.inbound.facade.ClienteFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.CadastroClienteCommand;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("chopper-house-games/cliente")
public class ClienteController {

    private final ClienteFacade facade;

    @Autowired
    public ClienteController(ClienteFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> registraCliente(@Valid @RequestBody CadastroClienteCommand cadastroClienteCommand) {
        return ResponseEntity.ok().body(facade.salvar(cadastroClienteCommand));
    }

    @PostMapping("editar")
    public ResponseEntity<ClienteDTO> editarCliente(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok().body(facade.editar(dto));
    }
}