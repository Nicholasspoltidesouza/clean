package com.projarc.clean.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.repository.IAplicativoRepository;

import lombok.RequiredArgsConstructor;

@Service
public class AplicativoService {
    private final IAplicativoRepository aplicativoRepository;

    @Autowired
    public AplicativoService(IAplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<AplicativoModel> listaTodosAplicativos() {
        return aplicativoRepository.findAll();
    }

    public AplicativoModel buscarPorId(Long id) {
        return aplicativoRepository.findById(id);
    }
}
