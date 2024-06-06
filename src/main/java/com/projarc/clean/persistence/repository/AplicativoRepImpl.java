package com.projarc.clean.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.repository.IAplicativoRepository;
import com.projarc.clean.persistence.entity.Aplicativo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
@Primary
public class AplicativoRepImpl implements IAplicativoRepository {
    private final AplicativoRepository aplicativoRepository;

    @Override
    public List<AplicativoModel> findAll() {
        return aplicativoRepository.findAll().stream().map(Aplicativo::toAplicativoModel).collect(Collectors.toList());
    }

    @Override
    public AplicativoModel findById(Long codigoAplicativo) {
        return aplicativoRepository.findById(codigoAplicativo).map(Aplicativo::toAplicativoModel).orElse(null);
    }

    @Override
    public AplicativoModel save(AplicativoModel aplicativo) {
        aplicativoRepository.save(Aplicativo.fromAplicativoModel(aplicativo));
        return aplicativo;
    }
}
