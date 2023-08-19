package br.com.fatec.chopperhousegames.inbound.controller;

import br.com.fatec.chopperhousegames.inbound.facade.ClienteFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.CadastroClienteCommand;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Controller
@RequestMapping("chopper-house-games/cliente")
public class ClienteController {

    private final ClienteFacade facade;

    private static final String MENSAGEM_ID_VAZIO = "O ID não pode ser vazio!";

    @Autowired
    public ClienteController(ClienteFacade facade) {
        this.facade = facade;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodosOsClientes(){
        return ResponseEntity.ok().body(facade.buscaTodos());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> registraCliente(@Valid @RequestBody CadastroClienteCommand cadastroClienteCommand) {
        return ResponseEntity.ok().body(facade.registraCliente(cadastroClienteCommand));
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> editarCliente(@RequestBody ClienteDTO dto) {
        return ResponseEntity.ok().body(facade.alteraDadosCliente(dto));
    }

    @DeleteMapping
    public void inativaCliente(@RequestParam @NotEmpty(message = MENSAGEM_ID_VAZIO) Long id){
        facade.inativaCliente(id);
    }
}