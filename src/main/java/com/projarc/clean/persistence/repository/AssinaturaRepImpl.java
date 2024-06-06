package com.projarc.clean.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
@Primary
public class AssinaturaRepImpl implements IAssinaturaRepository {

    private final AssinaturaRepository assinaturaRepository;

    @Override
    public AssinaturaModel save(AssinaturaModel assinatura) {
        if (assinaturaRepository.findLastId() == null) {
            assinatura.setId(1L);
        } else {
            assinatura.setId(assinaturaRepository.findLastId() + 1);
        }
        assinaturaRepository.save(Assinatura.fromAssinaturaModel(assinatura));
        return assinatura;
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

    @Override
    public List<AssinaturaModel> findAllByClienteId(Long codigoCliente) {
        return assinaturaRepository.findAllByClienteId(codigoCliente).stream().map(Assinatura::toAssinaturaModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssinaturaModel> findAllByAplicativoId(Long codigoAplicativo) {
        return assinaturaRepository.findAllByAplicativoId(codigoAplicativo).stream().map(Assinatura::toAssinaturaModel)
                .collect(Collectors.toList());
    }

    @Override
    public AssinaturaModel findById(Long codigoAssinatura) {
        return assinaturaRepository.findById(codigoAssinatura).map(Assinatura::toAssinaturaModel).orElse(null);
    }

    @Override
    public Long findLastId() {
        return assinaturaRepository.findLastId();
    }
}
