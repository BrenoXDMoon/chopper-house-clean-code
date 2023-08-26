package br.com.fatec.chopperhousegames.core.domain.service;

import br.com.fatec.chopperhousegames.core.domain.entity.Cupom;
import br.com.fatec.chopperhousegames.core.domain.entity.TipoCupom;

import java.util.List;

public interface CupomService {

    List<Cupom> listarTodosCupons();

    List<Cupom> buscarCuponsPorTipo(TipoCupom tipoCupom);
}
