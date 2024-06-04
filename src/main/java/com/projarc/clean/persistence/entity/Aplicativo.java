package com.projarc.clean.persistence.entity;

import com.projarc.clean.domain.models.AplicativoModel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "aplicativos", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Aplicativo {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @Column(name = "custo_mensal")
    private double custoMensal;

    public Aplicativo(Long id, String nome, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public Aplicativo fromAplicativoModel(AplicativoModel aplicativoModel) {
        return new Aplicativo(aplicativoModel.getId(), aplicativoModel.getNome(), aplicativoModel.getCustoMensal());
    }

    public AplicativoModel toAplicativoModel() {
        return new AplicativoModel(this.id, this.nome, this.custoMensal);
    }
}
