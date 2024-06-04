package com.projarc.clean.persistence.repository.impl;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import com.projarc.clean.domain.models.ClienteModel;
import com.projarc.clean.domain.repository.IClienteRepository;
import com.projarc.clean.persistence.entity.Cliente;
import com.projarc.clean.persistence.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ClienteRepositoryImpl implements IClienteRepository {
    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> findAll() {
        return clienteRepository.findAll().stream().map(Cliente::toClienteModel).collect(Collectors.toList());
    }

}
