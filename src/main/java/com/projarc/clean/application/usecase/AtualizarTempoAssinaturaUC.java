package com.projarc.clean.application.usecase;

import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.service.AssinaturaService;
import com.projarc.clean.persistence.entity.Assinatura;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AtualizarTempoAssinaturaUC {

    private final AssinaturaService assinaturaService;

    public AssinaturaDTO run(Long codigoAssinatura) {
        return Assinatura.fromModelToDTO(
                assinaturaService.atualizarTempoAssinatura(codigoAssinatura));
    }

}
