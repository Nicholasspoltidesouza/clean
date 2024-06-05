package com.projarc.clean.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.service.AssinaturaService;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

import lombok.RequiredArgsConstructor;

@Component
public class ListarAssinaturaPorTipoUC {

    private final AssinaturaService assinaturaService;

    @Autowired
    public ListarAssinaturaPorTipoUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(AssinaturaStatusEnum tipo) {
        return assinaturaService.listaAssinaturaPorTipo(tipo).stream().map(Assinatura::fromModelToDTO)
                .collect(Collectors.toList());
    }

}