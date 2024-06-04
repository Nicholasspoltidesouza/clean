package com.projarc.clean.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.clean.domain.models.PagamentoModel;
import com.projarc.clean.persistence.entity.Pagamento;

public interface IPagamentoRepository extends JpaRepository<Pagamento, Long> {
    Pagamento save(PagamentoModel pagamento);
}