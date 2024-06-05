package com.projarc.clean.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

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

    @Override
    public List<AssinaturaModel> findAllByStatus(AssinaturaStatusEnum status) {
        return assinaturaRepository.findAllByStatus(status).stream().map(Assinatura::toAssinaturaModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaModel> findAll() {
        return assinaturaRepository.findAll().stream().map(Assinatura::toAssinaturaModel).collect(Collectors.toList());
    }

}
