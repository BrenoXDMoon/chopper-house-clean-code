package br.com.fatec.chopperhousegames.inbound.controller;

import br.com.fatec.chopperhousegames.inbound.facade.CartaoFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.CartaoCreditoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("cartao")
public class CartaoCreditoController {

    private final CartaoFacade cartaoFacade;

    private static final String MENSAGEM_ID_VAZIO = "O ID não pode ser vazio!";

    @Autowired
    public CartaoCreditoController(CartaoFacade cartaoFacade) {
        this.cartaoFacade = cartaoFacade;
    }

    @GetMapping
    public ResponseEntity<List<CartaoCreditoDTO>> listarCartoes() {
        return ResponseEntity.ok().body(cartaoFacade.buscaTodosCartoes());
    }

    @PostMapping
    public ResponseEntity<CartaoCreditoDTO> salvaCartao(@Valid CartaoCreditoDTO dto) {
        return ResponseEntity.ok().body(cartaoFacade.registraCartao(dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirCartao(@RequestParam @NotEmpty(message = MENSAGEM_ID_VAZIO) Long id) {
        return ResponseEntity.ok().body(cartaoFacade.removeCartao(id));
    }

    @PutMapping
    public ResponseEntity<CartaoCreditoDTO> editaCartao(@Valid CartaoCreditoDTO cartaoDto) {
        return ResponseEntity.ok().body(cartaoFacade.alteraCartao(cartaoDto));
    }

}
