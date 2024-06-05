package com.projarc.clean.domain.models;

import java.util.Date;

import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

public class AssinaturaModel {
    private Long id;
    private ClienteModel cliente;
    private static AplicativoModel aplicativo;
    private Date dataInicio;
    private Date dataFim;
    private AssinaturaStatusEnum status;

    public AssinaturaModel(Long id, ClienteModel cliente, AplicativoModel aplicativo, Date dataInicio, Date dataFim,
            AssinaturaStatusEnum status) {
        this.id = id;
        this.cliente = cliente;
        this.aplicativo = aplicativo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public AssinaturaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public static AplicativoModel getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(AplicativoModel aplicativo) {
        this.aplicativo = aplicativo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public AssinaturaStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AssinaturaStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AssinaturaModel{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", aplicativo=" + aplicativo +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFim='" + dataFim + '\'' +
                '}';
    }
}
