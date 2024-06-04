package com.projarc.clean.domain.service;

import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.repository.IAplicativoRepository;
import com.projarc.clean.persistence.entity.Aplicativo;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
