package com.projarc.clean.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.service.AssinaturaService;
import com.projarc.clean.persistence.entity.Assinatura;

@Component
public class ListarAssinaturasDeUmClienteUC {

    private final AssinaturaService assinaturaService;

    @Autowired
    public ListarAssinaturasDeUmClienteUC(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    public List<AssinaturaDTO> run(Long codigoCliente) {
        return assinaturaService.listarAssinaturasDeUmCliente(codigoCliente).stream()
                .map(a -> Assinatura.fromModelToDTO(a)).collect(Collectors.toList());
    }
}
