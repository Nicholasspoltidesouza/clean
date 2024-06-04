package com.projarc.clean.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.clean.persistence.entity.Aplicativo;

public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    List<Aplicativo> findAll();

    Optional<Aplicativo> findById(Long codigo);
}
