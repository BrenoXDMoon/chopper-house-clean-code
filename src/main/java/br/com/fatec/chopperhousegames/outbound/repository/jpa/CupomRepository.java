package br.com.fatec.chopperhousegames.outbound.repository.jpa;

import br.com.fatec.chopperhousegames.core.domain.entity.Cupom;
import br.com.fatec.chopperhousegames.core.domain.entity.TipoCupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Integer> {

    @Query("SELECT c FROM Cupom c WHERE c.tipoCupom = :tipoCupom AND c.quantidade > 0")
    List<Cupom> buscaTodosCuponsDoTipoEQuantidadeMaiorQueZero(TipoCupom tipoCupom);
}
