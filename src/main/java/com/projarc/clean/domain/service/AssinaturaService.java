package com.projarc.clean.domain.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.models.ClienteModel;
import com.projarc.clean.domain.repository.IAplicativoRepository;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.domain.repository.IClienteRepository;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AssinaturaService {

    private final IAplicativoRepository aplicativoRepository;
    private final IClienteRepository clienteRepository;
    private final IAssinaturaRepository assinaturaRepository;

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

    public AssinaturaModel buscarPorId(Long id) {
        return assinaturaRepository.findById(id);
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

    public List<AssinaturaModel> listarAssinaturasDeUmAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.findAllByAplicativoId(codigoAplicativo);
    }

    public boolean checarSeAssinaturaEValida(Long codigoAssinatura) {
        return assinaturaRepository.findById(codigoAssinatura).getStatus().equals(AssinaturaStatusEnum.ATIVA);

    }

    public AssinaturaModel atualizarTempoAssinatura(Long codigoAssinatura) {
        AssinaturaModel assinatura = assinaturaRepository.findById(codigoAssinatura);
        assinatura.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
        assinaturaRepository.save(assinatura);
        return assinatura;
    }
}
