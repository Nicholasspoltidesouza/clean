package com.projarc.clean.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.ClienteDTO;
import com.projarc.clean.domain.service.ClienteService;

@Component
public class ListarTodosClientesUC {

    private ClienteService clienteService;

    @Autowired
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDTO> run() {
        return clienteService.listaTodosClientes().stream().map(c -> ClienteDTO.fromModel(c)).toList();
    }

}
