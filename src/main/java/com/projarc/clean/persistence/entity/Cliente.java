package com.projarc.clean.persistence.entity;

import com.projarc.clean.domain.models.ClienteModel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "clientes", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;

    public Cliente(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Cliente fromClienteModel(ClienteModel clienteModel) {
        return new Cliente(clienteModel.getId(), clienteModel.getNome(), clienteModel.getEmail());
    }

    public ClienteModel toClienteModel() {
        return new ClienteModel(this.id, this.nome, this.email);
    }
}
