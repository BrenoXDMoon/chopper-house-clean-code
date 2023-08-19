package br.com.fatec.chopperhousegames.inbound.controller;

import br.com.fatec.chopperhousegames.inbound.facade.EnderecoFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Controller
@RequestMapping("endereco")
public class EnderecoController {

    private final EnderecoFacade enderecoFacade;

    private static final String MENSAGEM_ID_VAZIO = "O ID não pode ser vazio!";

    @Autowired
    public EnderecoController(EnderecoFacade enderecoFacade) {
        this.enderecoFacade = enderecoFacade;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarEnderecos() {
        return ResponseEntity.ok().body(enderecoFacade.buscaTodosEnderecos());
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoDTO> buscaEndereco(@PathVariable @NotEmpty(message = MENSAGEM_ID_VAZIO) Long id) {
        return ResponseEntity.ok().body(enderecoFacade.buscaEnderecoPorId(id));
    }

    //TODO: criar uma Command para substituir o EnderecoDTO
    @PostMapping
    public ResponseEntity<EnderecoDTO> salvaEndereco(@Valid EnderecoDTO enderecoDto) {
        return ResponseEntity.ok().body(enderecoFacade.registraEndereco(enderecoDto));
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirEndereco(@RequestParam @NotEmpty(message = MENSAGEM_ID_VAZIO) Long id) {
        return ResponseEntity.ok().body(enderecoFacade.removeEndereco(id));
    }

    @PutMapping
    public ResponseEntity<EnderecoDTO> editaEndereco(@Valid EnderecoDTO enderecoDto) {
        return ResponseEntity.ok().body(enderecoFacade.alteraDadosEndereco(enderecoDto));
    }
}