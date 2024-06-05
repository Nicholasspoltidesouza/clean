package com.projarc.clean.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    Assinatura save(AssinaturaModel assinatura);

    List<Assinatura> findAllByStatus(AssinaturaStatusEnum status);

    List<Assinatura> findAll();

    List<Assinatura> findAllByClienteId(Long codigoCliente);

    List<Assinatura> findAllByAplicativoId(Long codigoAplicativo);

    Optional<Assinatura> findById(Long codigoAssinatura);
}
