package com.projarc.clean.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.service.AssinaturaService;
import com.projarc.clean.persistence.entity.Assinatura;

import lombok.RequiredArgsConstructor;

@Component
public class ListarTodasAssinaturasUC {

    private final AssinaturaService assinaturaService;

    @Autowired
    public ListarTodasAssinaturasUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run() {
        return assinaturaService.listaTodasAssinaturas().stream().map(Assinatura::fromModelToDTO)
                .collect(Collectors.toList());
    }

}
