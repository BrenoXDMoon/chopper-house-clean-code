package br.com.fatec.chopperhousegames.core.repository;

import br.com.fatec.chopperhousegames.core.domain.entity.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartaoCreditoRepository {
    Optional<CartaoCredito> findById(Long id);

    List<CartaoCredito> findAll();

    CartaoCredito save(CartaoCredito cartao);

    void delete(CartaoCredito cartaoCredito);
}
