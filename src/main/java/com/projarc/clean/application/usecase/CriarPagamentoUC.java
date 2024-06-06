package com.projarc.clean.application.usecase;

import org.springframework.stereotype.Component;

import com.projarc.clean.application.dto.PagamentoDTO;
import com.projarc.clean.domain.service.AssinaturaService;
import com.projarc.clean.domain.service.PagamentoService;
import com.projarc.clean.persistence.entity.Pagamento;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CriarPagamentoUC {

    private final PagamentoService pagamentoService;

    private final AssinaturaService assinaturaService;

    public PagamentoDTO run(Long codigoAssinatura, Double valor, String promocao) {
        return Pagamento.fromModelToDTO(
                pagamentoService.realizarPagamento(assinaturaService.buscarPorId(codigoAssinatura), valor, promocao));
    }
}
