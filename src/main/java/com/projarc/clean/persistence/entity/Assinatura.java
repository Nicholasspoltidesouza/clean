package com.projarc.clean.persistence.entity;

import java.sql.Date;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.domain.models.AssinaturaModel;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "assinaturas", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Assinatura {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aplicativo_id")
    private Aplicativo aplicativo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Enumerated(EnumType.ORDINAL)
    private AssinaturaStatusEnum status;

    public Assinatura() {
    }

    public Assinatura(Long id, Aplicativo aplicativo, Cliente cliente, Date dataInicio, Date dataFim,
            AssinaturaStatusEnum status) {
        this.id = id;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public AssinaturaModel toAssinaturaModel() {
        this.getCliente();
        this.getAplicativo();
        return new AssinaturaModel(
                this.getId(),
                Cliente.toClienteModel(cliente),
                Aplicativo.toAplicativoModel(aplicativo),
                this.getDataInicio(),
                this.getDataFim(),
                this.getStatus());
    }

    public static Assinatura fromAssinaturaModel(AssinaturaModel assinaturaModel) {
        Cliente cliente = Cliente.fromClienteModel(assinaturaModel.getCliente());
        Aplicativo aplicativo = Aplicativo.fromAplicativoModel(assinaturaModel.getAplicativo());
        return new Assinatura(
                assinaturaModel.getId(),
                aplicativo,
                cliente,
                assinaturaModel.getDataInicio(),
                assinaturaModel.getDataFim(),
                assinaturaModel.getStatus());
    }

    public static AssinaturaDTO fromModelToDTO(AssinaturaModel a) {
        return new AssinaturaDTO(
                a.getId(),
                Cliente.fromModelToDTO(a.getCliente()),
                Aplicativo.fromModelToDTO(a.getAplicativo()),
                a.getDataInicio(),
                a.getDataFim(),
                a.getStatus());
    }
}
