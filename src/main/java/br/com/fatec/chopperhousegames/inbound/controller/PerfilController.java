package br.com.fatec.chopperhousegames.inbound.controller;

import br.com.fatec.chopperhousegames.inbound.facade.ClienteFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfil")
public class PerfilController {

    private final ClienteFacade clienteFacade;

    public PerfilController(ClienteFacade facade) {
        this.clienteFacade = facade;
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteDTO> perfil(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(clienteFacade.buscarPorId(id));
    }

//    @PostMapping("{id}/senha")
//    public ResponseEntity editarSenha(@PathVariable("id") Long id, @Valid SenhaDTO dto) {
//        return editarSenha(id, dto);
//    }

    //TODO: Refatorar quando for olhar o fluxo de pedido
//    @GetMapping("perfil/{id}/devolucao/{idPed}")
//    public ModelAndView acessarFormularioDevolucao(@PathVariable("id") Cliente cliente, @PathVariable("idPed") Pedido pedido) {
//        ModelAndView mv = new ModelAndView("cliente/pedido/formDevolucao");
//        mv.addObject(CLIENTE_SESSAO, service.atualUsuarioLogado());
//        DevolucaoDto devolucaoDto = new DevolucaoDto();
//        devolucaoDto.setPedido(pedidoService.buscarById(pedido.getId()));
//        mv.addObject("dto", devolucaoDto);
//        return mv;
//    }
//
//    @PostMapping("{id}/devolucao/{idPed}")
//    public ModelAndView solicitarDevolucaoPedido(@PathVariable("id") Cliente cliente, @PathVariable("idPed") Pedido pedido, @ModelAttribute DevolucaoDto dto) {
//        ModelAndView mv = new ModelAndView("cliente/perfil");
//        Devolucao devolucao = new Devolucao();
//        devolucao.setMotivo(dto.getMotivo());
//        devolucao.setStatusDevolucao(dto.getStatusDevolucao());
//        pedido = pedidoService.buscarById(pedido.getId());
//
//        Integer i = 0;
//        for (Item item : pedido.getItens()) {
//            item.setQuantidadeTroca(dto.getPedido().getItens().get(i).getQuantidadeTroca());
//            i++;
//        }
//        devolucao.setPedido(pedido);
//
//        devolucaoService.salvarSolicitacaoDevolucao(devolucao);
//
//        mv.addObject(CLIENTE_SESSAO, service.atualUsuarioLogado());
//        mv.addObject(MENSAGEM_SESSAO, "Solicitação de troca enviada com sucesso!");
//
//        return mv;
//    }
//
//    @GetMapping("{id}/pedidos/visualizar/{idPed}")
//    public ModelAndView visualizarPedido(@PathVariable("id") Cliente cliente, @PathVariable("idPed") Pedido pedido) {
//        ModelAndView mv = new ModelAndView("cliente/pedido/detalhe");
//        mv.addObject(CLIENTE_SESSAO, cliente);
//        mv.addObject("pedido", pedidoService.buscarById(pedido.getId()));
//        mv.addObject("devolucaoExist", devolucaoService.buscaDevolucaoByPedidoId(pedido));
//        mv.addObject("devolucao", new Devolucao());
//        return mv;
//    }

}
