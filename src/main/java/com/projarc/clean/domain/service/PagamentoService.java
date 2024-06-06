package com.projarc.clean.domain.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.domain.models.PagamentoModel;
import com.projarc.clean.domain.repository.IPagamentoRepository;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;
import com.projarc.clean.persistence.enumeration.PagamentoStatusEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PagamentoService {
    private final IPagamentoRepository pagamentoRepository;

    public PagamentoModel realizarPagamento(AssinaturaModel assinatura, Double valorPago, String promocao) {

        PagamentoModel pagamento = new PagamentoModel();
        pagamento.setAssinatura(assinatura);
        pagamento.setDataPagamento(Date.valueOf(LocalDate.now()));
        pagamento.setValorPago(valorPago);

        if (valorPago < AssinaturaModel.getAplicativo()
                .getCustoMensal()) {
            pagamento.setStatus(PagamentoStatusEnum.VALOR_INCORRETO);
            pagamento.setValorEstornado(AssinaturaModel.getAplicativo().getCustoMensal() - valorPago);
        } else {
            pagamento.setStatus(PagamentoStatusEnum.PAGAMENTO_OK);
            assinatura.setStatus(AssinaturaStatusEnum.ATIVA);
            assinatura.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
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