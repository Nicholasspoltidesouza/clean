package com.projarc.clean.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.models.PagamentoModel;
import com.projarc.clean.domain.repository.IPagamentoRepository;
import com.projarc.clean.persistence.enumeration.PagamentoStatusEnum;

@Service
public class PagamentoService {
    private final IPagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoService(IPagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    // public PagamentoModel realizarPagamento(AssinaturaModel assinatura, Float
    // valorPago, Date dataPagamento,
    // String promocao, PagamentoStatusEnum status) {
    // if (valorPago < assinatura.getAplicativo().getCustoMensal() || valorPago >
    // assinatura.getAplicativo().getCustoMensal()){
    // PagamentoModel pagamento = new PagamentoModel(null, assinatura, valorPago,
    // dataPagamento, promocao,
    // PagamentoStatusEnum.VALOR_INCORRETO);
    // }else{
    // PagamentoModel pagamento = new PagamentoModel(null, assinatura, valorPago,
    // dataPagamento, promocao,
    // PagamentoStatusEnum.PAGAMENTO_OK);
    // }
    // pagamentoRepository.save(pagamento);
    // return pagamento;
    // }
}