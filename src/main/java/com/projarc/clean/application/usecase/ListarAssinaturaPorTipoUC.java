package com.projarc.clean.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.service.AssinaturaService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListarAssinaturaPorTipoUC {

    private final AssinaturaService assinaturaService;

    public List<AssinaturaDTO> run(String tipo) {
        return assinaturaService.listaAssinaturaPorTipo(tipo).stream().map(a -> AssinaturaDTO.fromModel(a))
                .collect(Collectors.toList());
    }

}
