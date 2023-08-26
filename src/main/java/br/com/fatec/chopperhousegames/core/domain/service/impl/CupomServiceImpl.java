package br.com.fatec.chopperhousegames.core.domain.service.impl;

import br.com.fatec.chopperhousegames.core.domain.entity.Cupom;
import br.com.fatec.chopperhousegames.core.domain.entity.TipoCupom;
import br.com.fatec.chopperhousegames.outbound.repository.jpa.CupomRepository;
import br.com.fatec.chopperhousegames.core.domain.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CupomServiceImpl implements CupomService {

    @Autowired
    private CupomRepository repository;

    @Override
    public List<Cupom> listarTodosCupons() {
        return repository.findAll();
    }

    @Override
    public List<Cupom> buscarCuponsPorTipo(TipoCupom tipoCupom) {
        return repository.buscaTodosCuponsDoTipoEQuantidadeMaiorQueZero(tipoCupom);
    }
}