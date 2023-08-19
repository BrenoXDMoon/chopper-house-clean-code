package br.com.fatec.chopperhousegames.outbound.repository.jpa;

import br.com.fatec.chopperhousegames.core.domain.entity.Cliente;
import br.com.fatec.chopperhousegames.core.repository.ClienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente, Long>, ClienteRepository {

    Optional<Cliente> findByEmail(String email);

    @Modifying
    @Query("UPDATE Cliente c SET c.ativo = false WHERE c.id = :id")
    void inativaClientePorId(Long id);
}
