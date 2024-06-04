package com.projarc.clean.persistence.repository.impl;

import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.repository.AssinaturaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class AssinaturaRepositoryImpl implements IAssinaturaRepository {

    private final AssinaturaRepository assinaturaRepository;

    @Override
    public Assinatura save(AssinaturaModel assinatura) {
        return assinaturaRepository.save(assinatura);
    }

}
