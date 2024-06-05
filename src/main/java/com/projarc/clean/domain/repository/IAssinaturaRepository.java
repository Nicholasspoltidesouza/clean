package com.projarc.clean.domain.repository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.persistence.entity.Assinatura;

public interface IAssinaturaRepository {
    Assinatura save(AssinaturaModel assinatura);

    AssinaturaModel findByStatus(String tipo);
}
