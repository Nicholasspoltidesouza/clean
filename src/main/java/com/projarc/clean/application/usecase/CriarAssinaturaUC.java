package com.projarc.clean.application.usecase;

import org.springframework.stereotype.Service;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.service.AssinaturaService;
import com.projarc.clean.persistence.entity.Assinatura;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CriarAssinaturaUC {

    private final AssinaturaService assinaturaService;

    public AssinaturaDTO run(Long codigoCliente, Long codigoAplicativo) {
        return Assinatura.fromModelToDTO(
                assinaturaService.criarAssinatura(codigoCliente, codigoAplicativo));
    }
}
