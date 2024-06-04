package com.projarc.clean.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.persistence.entity.Assinatura;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    Assinatura save(AssinaturaModel assinatura);

}
