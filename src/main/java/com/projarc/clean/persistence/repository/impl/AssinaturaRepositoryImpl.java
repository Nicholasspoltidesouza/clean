package com.projarc.clean.persistence.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.repository.AssinaturaRepository;

import lombok.RequiredArgsConstructor;

@Repository
public class AssinaturaRepositoryImpl implements IAssinaturaRepository {

    private final AssinaturaRepository assinaturaRepository;

    @Autowired
    public AssinaturaRepositoryImpl(@Lazy AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    @Override
    public Assinatura save(AssinaturaModel assinatura) {
        return assinaturaRepository.save(assinatura);
    }

}
