package com.projarc.clean.persistence.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.repository.IAplicativoRepository;
import com.projarc.clean.persistence.entity.Aplicativo;
import com.projarc.clean.persistence.repository.AplicativoRepository;

import lombok.RequiredArgsConstructor;

@Repository
public class AplicativoRepositoryImpl implements IAplicativoRepository {
    private final AplicativoRepository aplicativoRepository;

    @Autowired
    public AplicativoRepositoryImpl(@Lazy AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @Override
    public List<AplicativoModel> findAll() {
        return aplicativoRepository.findAll().stream().map(a -> Aplicativo.toAplicativoModel(a))
                .collect(Collectors.toList());
    }

    @Override
    public AplicativoModel findById(Long codigoAplicativo) {
        return aplicativoRepository.findById(codigoAplicativo).map(Aplicativo::toAplicativoModel).orElse(null);
    }

}
