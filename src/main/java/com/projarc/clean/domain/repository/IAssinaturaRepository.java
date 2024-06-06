package com.projarc.clean.domain.repository;

import java.util.List;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

public interface IAssinaturaRepository {
    AssinaturaModel save(AssinaturaModel assinatura);

    List<AssinaturaModel> findAllByStatus(AssinaturaStatusEnum status);

    List<AssinaturaModel> findAll();

    List<AssinaturaModel> findAllByClienteId(Long codigoCliente);

    List<AssinaturaModel> findAllByAplicativoId(Long codigoAplicativo);

    AssinaturaModel findById(Long codigoAssinatura);

    Long findLastId();
}
