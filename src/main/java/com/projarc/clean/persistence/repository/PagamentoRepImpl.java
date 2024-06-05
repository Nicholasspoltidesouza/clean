package com.projarc.clean.persistence.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.projarc.clean.domain.models.PagamentoModel;
import com.projarc.clean.domain.repository.IPagamentoRepository;
import com.projarc.clean.persistence.entity.Pagamento;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
@Primary
public class PagamentoRepImpl implements IPagamentoRepository {

    private final PagamentoRepository pagamentoRepository;

    @Override
    public PagamentoModel save(PagamentoModel pagamento) {
        pagamentoRepository.save(Pagamento.fromPagamentoModel(pagamento));
        return pagamento;
    }

}
