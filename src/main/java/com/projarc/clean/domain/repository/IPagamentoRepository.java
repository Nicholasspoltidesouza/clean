package com.projarc.clean.domain.repository;

import com.projarc.clean.domain.models.PagamentoModel;

public interface IPagamentoRepository {
    PagamentoModel save(PagamentoModel pagamento);
}