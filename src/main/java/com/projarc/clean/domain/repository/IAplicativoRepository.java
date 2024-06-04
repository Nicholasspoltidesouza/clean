package com.projarc.clean.domain.repository;

import com.projarc.clean.domain.models.AplicativoModel;

import java.util.List;

public interface IAplicativoRepository {
    List<AplicativoModel> findAll();

    AplicativoModel findById(Long codigoAplicativo);
}
