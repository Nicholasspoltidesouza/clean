package com.projarc.clean.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projarc.clean.persistence.entity.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Pagamento save(Pagamento pagamento);

    @Query(value = "SELECT id FROM pagamentos ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Long findLastId();

}
