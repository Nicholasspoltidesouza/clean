package com.projarc.clean.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AplicativoDTO;
import com.projarc.clean.domain.service.AplicativoService;

@Component
public class ListarTodosAplicativosUC {

    private AplicativoService aplicativoService;

    @Autowired
    public void setAplicativoService(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public List<AplicativoDTO> run() {
        return aplicativoService.listaTodosAplicativos().stream().map(a -> AplicativoDTO.fromModel(a))
                .collect(Collectors.toList());
    }

}
