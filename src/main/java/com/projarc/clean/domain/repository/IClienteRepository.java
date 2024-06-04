package com.projarc.clean.domain.repository;

import com.projarc.clean.domain.models.ClienteModel;

import java.util.List;

public interface IClienteRepository {
    List<ClienteModel> findAll();
}
