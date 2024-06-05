package com.projarc.clean.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.service.AssinaturaService;
import com.projarc.clean.persistence.entity.Assinatura;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ListarAssinaturasDeUmAplicativoUC {

    private final AssinaturaService assinaturaService;

    public List<AssinaturaDTO> run(Long codigoAplicativo) {
        return assinaturaService.listarAssinaturasDeUmAplicativo(codigoAplicativo).stream()
                .map(a -> Assinatura.fromModelToDTO(a)).collect(Collectors.toList());
    }

}
