package br.com.fatec.chopperhousegames.inbound.controller;

import br.com.fatec.chopperhousegames.core.domain.entity.Cliente;
import br.com.fatec.chopperhousegames.core.domain.entity.Devolucao;
import br.com.fatec.chopperhousegames.core.domain.entity.Item;
import br.com.fatec.chopperhousegames.core.domain.entity.Pedido;
import br.com.fatec.chopperhousegames.core.domain.service.ClienteService;
import br.com.fatec.chopperhousegames.core.domain.service.DevolucaoService;
import br.com.fatec.chopperhousegames.core.domain.service.PedidoService;
import br.com.fatec.chopperhousegames.inbound.facade.ClienteFacade;
import br.com.fatec.chopperhousegames.inbound.facade.dto.ClienteDTO;
import br.com.fatec.chopperhousegames.inbound.facade.dto.DevolucaoDto;
import br.com.fatec.chopperhousegames.inbound.facade.dto.SenhaDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("perfil")
public class PerfilController {

    private static final String CLIENTE_SESSAO = "cliente";

    private static final String MENSAGEM_SESSAO = "mensagem";

    private static final String CAMINHO_PERFIL_CLIENTE = "/cliente/perfil";

    private final ClienteService service;

    private final ClienteFacade facade;

    private final PedidoService pedidoService;

    private final DevolucaoService devolucaoService;

    public PerfilController(ClienteService service, ClienteFacade facade, PedidoService pedidoService, DevolucaoService devolucaoService) {
        this.service = service;
        this.facade = facade;
        this.pedidoService = pedidoService;
        this.devolucaoService = devolucaoService;
    }

    @GetMapping("{id}")
    public ModelAndView perfil(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView();
        if (facade.usuarioEstaLogado(id)) {
            ClienteDTO dto = facade.atualUsuarioLogado();
//            if (validator.validaRoleUsuario(dto)) {
//                mv.setViewName(CAMINHO_PERFIL_CLIENTE);
//                mv.addObject(CLIENTE_SESSAO, dto);
//            } else {
//                mv.setViewName("/admin/dashboard");
//                mv.addObject("admin", dto);
//            }
        }

        return mv;
    }



    @GetMapping("{id}/senha")
    public ModelAndView editarSenha(@PathVariable("id") Long id, SenhaDTO senhaDto, ModelAndView mv) {
        if (mv == null) {
            mv = new ModelAndView();
        }
        mv.setViewName("/cliente/senha");
        mv.addObject(facade.atualUsuarioLogado());
        return mv;
    }

    @PostMapping("{id}/senha")
    public ModelAndView editarSenha(@PathVariable("id") Long id, @Valid SenhaDTO dto, BindingResult result) {
        ModelAndView mv = new ModelAndView(CAMINHO_PERFIL_CLIENTE);
        ClienteDTO clienteDTO = facade.atualUsuarioLogado();
//        if (validator.validaAlteracaoSenha(dto, clienteDTO, result).hasErrors()) {
//            mv.addObject("resultados", result);
//            return editarSenha(clienteDTO.getId(), dto, mv);
//        }
        mv.addObject(CLIENTE_SESSAO, facade.editarSenha(clienteDTO, dto));
        mv.addObject(MENSAGEM_SESSAO, "Senha atualizada com sucesso!");
        return mv;
    }

    @GetMapping("perfil/{id}/devolucao/{idPed}")
    public ModelAndView acessarFormularioDevolucao(@PathVariable("id") Cliente cliente, @PathVariable("idPed") Pedido pedido) {
        ModelAndView mv = new ModelAndView("cliente/pedido/formDevolucao");
        mv.addObject(CLIENTE_SESSAO, service.atualUsuarioLogado());
        DevolucaoDto devolucaoDto = new DevolucaoDto();
        devolucaoDto.setPedido(pedidoService.buscarById(pedido.getId()));
        mv.addObject("dto", devolucaoDto);
        return mv;
    }

    @PostMapping("{id}/devolucao/{idPed}")
    public ModelAndView solicitarDevolucaoPedido(@PathVariable("id") Cliente cliente, @PathVariable("idPed") Pedido pedido, @ModelAttribute DevolucaoDto dto) {
        ModelAndView mv = new ModelAndView("cliente/perfil");
        Devolucao devolucao = new Devolucao();
        devolucao.setMotivo(dto.getMotivo());
        devolucao.setStatusDevolucao(dto.getStatusDevolucao());
        pedido = pedidoService.buscarById(pedido.getId());

        Integer i = 0;
        for (Item item : pedido.getItens()) {
            item.setQuantidadeTroca(dto.getPedido().getItens().get(i).getQuantidadeTroca());
            i++;
        }
        devolucao.setPedido(pedido);

        devolucaoService.salvarSolicitacaoDevolucao(devolucao);

        mv.addObject(CLIENTE_SESSAO, service.atualUsuarioLogado());
        mv.addObject(MENSAGEM_SESSAO, "Solicitação de troca enviada com sucesso!");

        return mv;
    }

    @GetMapping("{id}/pedidos/visualizar/{idPed}")
    public ModelAndView visualizarPedido(@PathVariable("id") Cliente cliente, @PathVariable("idPed") Pedido pedido) {
        ModelAndView mv = new ModelAndView("cliente/pedido/detalhe");
        mv.addObject(CLIENTE_SESSAO, cliente);
        mv.addObject("pedido", pedidoService.buscarById(pedido.getId()));
        mv.addObject("devolucaoExist", devolucaoService.buscaDevolucaoByPedidoId(pedido));
        mv.addObject("devolucao", new Devolucao());
        return mv;
    }

}
