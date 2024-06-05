package com.projarc.clean.domain.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.models.PagamentoModel;
import com.projarc.clean.domain.repository.IPagamentoRepository;
import com.projarc.clean.persistence.enumeration.PagamentoStatusEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PagamentoService {
    private final IPagamentoRepository pagamentoRepository;

    public PagamentoModel realizarPagamento(AssinaturaModel assinatura, Double valorPago, String promocao) {

        PagamentoModel pagamento = new PagamentoModel();
        pagamento.setAssinatura(assinatura);
        pagamento.setDataPagamento(new Date());
        pagamento.setValorPago(valorPago);

        if (valorPago < AssinaturaModel.getAplicativo()
                .getCustoMensal()) {
            pagamento.setStatus(PagamentoStatusEnum.VALOR_INCORRETO);
            pagamento.setValorEstornado(AssinaturaModel.getAplicativo().getCustoMensal() - valorPago);
        } else {
            pagamento.setStatus(PagamentoStatusEnum.PAGAMENTO_OK);

        }
        if (promocao != null && promocao != "") {
            pagamento.setPromocao(promocao);
            AssinaturaModel.getAplicativo().setCustoMensal(AssinaturaModel.getAplicativo().getCustoMensal() * 0.8);
            pagamento.setValorEstornado(valorPago - AssinaturaModel.getAplicativo().getCustoMensal());
        }
        pagamentoRepository.save(pagamento);
        return pagamento;
    }
}