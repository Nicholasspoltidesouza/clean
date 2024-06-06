package com.projarc.clean.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.AplicativoDTO;
import com.projarc.clean.domain.service.AplicativoService;
import com.projarc.clean.persistence.entity.Aplicativo;

@Component
public class ListarTodosAplicativosUC {

    private AplicativoService aplicativoService;

    @Autowired
    public ListarTodosAplicativosUC(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    public List<AplicativoDTO> run() {
        return aplicativoService.listaTodosAplicativos().stream().map(a -> Aplicativo.fromModelToDTO(a))
                .collect(Collectors.toList());
    }

}
