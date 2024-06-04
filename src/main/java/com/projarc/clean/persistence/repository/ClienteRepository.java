package com.projarc.clean.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projarc.clean.persistence.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAll();

}
