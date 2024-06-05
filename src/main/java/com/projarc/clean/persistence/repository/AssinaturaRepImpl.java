package com.projarc.clean.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.persistence.entity.Assinatura;

@Repository
@Primary
public class AssinaturaRepImpl implements IAssinaturaRepository {

    private final AssinaturaRepository assinaturaRepository;

    @Autowired
    public AssinaturaRepImpl(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    @Override
    public Assinatura save(AssinaturaModel assinatura) {
        return save(assinatura);
    }

}
