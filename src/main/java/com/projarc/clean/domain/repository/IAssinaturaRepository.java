package com.projarc.clean.domain.repository;

import java.util.List;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

public interface IAssinaturaRepository {
    Assinatura save(AssinaturaModel assinatura);

    List<AssinaturaModel> findAllByStatus(AssinaturaStatusEnum status);

    List<AssinaturaModel> findAll();
}
