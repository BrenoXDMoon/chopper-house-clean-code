package br.com.fatec.chopperhousegames.inbound.controller;

import br.com.fatec.chopperhousegames.inbound.facade.ClienteFacade;
import br.com.fatec.chopperhousegames.inbound.facade.DevolucaoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/devolucoes")
public class DevolucaoController {

    //TODO: refatorar controller de devolucao para usar a fachada

    private final DevolucaoFacade devolucaoService;

    private final ClienteFacade clienteService;

    public DevolucaoController(DevolucaoFacade devolucaoService, ClienteFacade clienteService) {
        this.devolucaoService = devolucaoService;
        this.clienteService = clienteService;
    }
//
//    @GetMapping
//    public ModelAndView listarDevolucoes(ModelAndView mv){
//
//        if(mv == null){
//            mv = new ModelAndView();
//        }
//        mv.setViewName("admin/pedido/listaDevolucao");
//        mv.addObject("pedidos", devolucaoService.buscarTodos());
//
//        return mv;
//    }
//
//    @PostMapping("{id}")
//    public ModelAndView alterarStatusDevolucao(@PathVariable("id") Devolucao devolucao){
//        ModelAndView mv = new ModelAndView("redirect:/admin/devolucoes");
//        devolucaoService.editar(devolucao);
//        System.out.println("tentando editar de " + devolucao.getStatusDevolucao().getDescricao());
//        return mv;
//    }
//
//    @GetMapping("{id}")
//    public ModelAndView visualizarDevolucao(@PathVariable("id") Devolucao devolucao){
//
//        ModelAndView mv = new ModelAndView("admin/pedido/detalheDevolucao");
//
//        mv.addObject("devolucao", devolucaoService.buscarById(devolucao.getId()));
//
//        return mv;
//    }
//
//    @PostMapping("{id}/aceitar")
//    public ModelAndView aceitarTroca(@PathVariable("id") Devolucao devolucao){
//
//        ModelAndView mv = new ModelAndView("redirect:/admin/devolucoes");
//        devolucaoService.aceitar(devolucao);
//        return mv;
//    }
//
//    @PostMapping("{id}/recusar")
//    public ModelAndView recusarTroca(@PathVariable("id") Devolucao devolucao){
//
//        ModelAndView mv = new ModelAndView("redirect:/admin/devolucoes");
//        devolucaoService.recusar(devolucao);
//        return mv;
//    }
//
//    @PostMapping("{id}/processar")
//    public ModelAndView processarTroca(@PathVariable("id") Devolucao devolucao){
//
//        Cliente cliente = clienteService.atualUsuarioLogado();
//        ModelAndView mv = new ModelAndView("redirect:/cliente/perfil/" + cliente.getId() +"/pedidos");
//        devolucaoService.processar(devolucao);
//        return mv;
//    }
//
//    @PostMapping("{id}/receber")
//    public ModelAndView receberTroca(@PathVariable("id") Devolucao devolucao){
//
//        ModelAndView mv = new ModelAndView("redirect:/admin/devolucoes");
//        devolucaoService.finalizar(devolucao);
//        return mv;
//    }
}
