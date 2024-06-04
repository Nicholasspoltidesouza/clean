package com.projarc.clean.persistence.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import com.projarc.clean.domain.models.ClienteModel;
import com.projarc.clean.domain.repository.IClienteRepository;
import com.projarc.clean.persistence.entity.Cliente;
import com.projarc.clean.persistence.repository.ClienteRepository;

@Repository
@Primary
public class ClienteRepositoryImpl implements IClienteRepository {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteRepositoryImpl(@Lazy ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteModel> findAll() {
        return clienteRepository.findAll().stream().map(Cliente::toClienteModel).collect(Collectors.toList());
    }

    @Override
    public ClienteModel findById(Long codigoCliente) {
        return clienteRepository.findById(codigoCliente).map(Cliente::toClienteModel).orElse(null);
    }
}
