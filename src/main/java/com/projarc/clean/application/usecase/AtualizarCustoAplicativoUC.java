package com.projarc.clean.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AplicativoDTO;
import com.projarc.clean.application.dto.AplicativoPatchDTO;
import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.service.AplicativoService;
import com.projarc.clean.persistence.entity.Aplicativo;

import lombok.RequiredArgsConstructor;

@Component
public class AtualizarCustoAplicativoUC {

    private AplicativoService aplicativoService;

    @Autowired
    public AtualizarCustoAplicativoUC(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public AplicativoDTO run(Long idAplicativo, Double custoMensal) {
        AplicativoModel aplicativo = aplicativoService.atualizarCusto(idAplicativo, custoMensal);
        return Aplicativo.fromModelToDTO(aplicativo);
    }

}
