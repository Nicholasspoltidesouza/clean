package com.projarc.clean.application.usecase;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.ClienteDTO;
import com.projarc.clean.domain.service.ClienteService;

@Component
public class ListarTodosClientesUC {

    private ClienteService clienteService;

    @Autowired
    public ListarTodosClientesUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Collection<ClienteDTO> run() {
        return clienteService.listaTodosClientes().stream().map(ClienteDTO::fromModel)
                .collect(Collectors.toList());
    }

}
