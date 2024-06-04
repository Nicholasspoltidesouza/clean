package com.projarc.clean.domain.service;

import com.projarc.clean.domain.models.AplicativoModel;
import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.models.ClienteModel;
import com.projarc.clean.domain.repository.IAplicativoRepository;
import com.projarc.clean.domain.repository.IAssinaturaRepository;
import com.projarc.clean.domain.repository.IClienteRepository;
import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

import lombok.RequiredArgsConstructor;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AssinaturaService {
    private final IAssinaturaRepository assinaturaRepository;
    private final IClienteRepository clienteRepository;
    private final IAplicativoRepository aplicativoRepository;

    public AssinaturaModel criarAssinatura(Long codigoCliente, Long codigoAplicativo) {
        ClienteModel cliente = clienteRepository.findById(codigoCliente);
        AplicativoModel aplicativo = aplicativoRepository.findById(codigoAplicativo);

        if (cliente == null || aplicativo == null) {
            throw new IllegalArgumentException("Cliente ou Aplicativo não encontrado");
        }

        Date dataInicio = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInicio);
        cal.add(Calendar.DAY_OF_MONTH, 7); // 7 dias grátis
        Date dataFim = cal.getTime();

        AssinaturaModel assinatura = new AssinaturaModel(null, cliente, aplicativo, dataInicio, dataFim,
                AssinaturaStatusEnum.ATIVA);
        return assinaturaRepository.save(assinatura);
    }
}
