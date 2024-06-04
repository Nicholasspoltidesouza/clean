package com.projarc.clean.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.clean.persistence.entity.Aplicativo;

public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {

}
