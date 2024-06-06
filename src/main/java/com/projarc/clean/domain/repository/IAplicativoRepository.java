package com.projarc.clean.domain.repository;

import java.util.List;

import com.projarc.clean.domain.models.AplicativoModel;

public interface IAplicativoRepository {
    List<AplicativoModel> findAll();

    AplicativoModel findById(Long codigoAplicativo);

    AplicativoModel save(AplicativoModel aplicativo);
}
