package com.projarc.clean.domain.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.clean.application.dto.AssinaturaNovaDTO;
import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.models.ClienteModel;
import com.projarc.clean.domain.repository.IAplicativoRepository;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.domain.repository.IClienteRepository;
import com.projarc.clean.persistence.entity.Aplicativo;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.entity.Cliente;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

import lombok.RequiredArgsConstructor;

@Service
public class AssinaturaService {

    private final IAplicativoRepository aplicativoRepository;
    private final IClienteRepository clienteRepository;
    private final IAssinaturaRepository assinaturaRepository;

    @Autowired
    public AssinaturaService(IAplicativoRepository aplicativoRepository,
            IClienteRepository clienteRepository,
            IAssinaturaRepository assinaturaRepository) {
        this.aplicativoRepository = aplicativoRepository;
        this.clienteRepository = clienteRepository;
        this.assinaturaRepository = assinaturaRepository;
    }

    public AssinaturaModel criarAssinatura(Long codigoCliente, Long codigoAplicativo) {
        ClienteModel cliente = clienteRepository.findById(codigoCliente);
        AplicativoModel aplicativo = aplicativoRepository.findById(codigoAplicativo);

        AssinaturaModel assinatura = new AssinaturaModel();
        assinatura.setCliente(cliente);
        assinatura.setAplicativo(aplicativo);
        assinatura.setDataInicio(Date.valueOf(LocalDate.now()));
        assinatura.setDataFim(Date.valueOf(LocalDate.now().plusDays(7)));
        assinatura.setStatus(AssinaturaStatusEnum.ATIVA);

        assinaturaRepository.save(assinatura);
        return assinatura;
    }

    public List<AssinaturaModel> listaAssinaturaPorTipo(AssinaturaStatusEnum tipo) {
        return assinaturaRepository.findAllByStatus(tipo);
    }

    public List<AssinaturaModel> listaTodasAssinaturas() {
        return assinaturaRepository.findAll();
    }

    public List<AssinaturaModel> listarAssinaturasDeUmCliente(Long codigoCliente) {
        return assinaturaRepository.findAllByClienteId(codigoCliente);
    }
}
