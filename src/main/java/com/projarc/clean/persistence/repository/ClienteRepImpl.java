package com.projarc.clean.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.ClienteModel;
import com.projarc.clean.domain.repository.IClienteRepository;
import com.projarc.clean.persistence.entity.Cliente;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
@Primary
public class ClienteRepImpl implements IClienteRepository {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> findAll() {
        return clienteRepository.findAll().stream()
                .map(Cliente::toClienteModel)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteModel findById(Long codigoCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(codigoCliente);
        return cliente.map(Cliente::toClienteModel).orElse(null);
    }
}
