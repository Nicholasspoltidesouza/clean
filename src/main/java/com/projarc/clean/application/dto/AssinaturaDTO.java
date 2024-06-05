package com.projarc.clean.application.dto;

import java.util.Date;

import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

public class AssinaturaDTO {

    private Long id;
    private ClienteDTO cliente;
    private AplicativoDTO aplicativo;
    private Date dataInicio;
    private Date dataFim;
    private AssinaturaStatusEnum status;

    public AssinaturaDTO(Long id, ClienteDTO cliente, AplicativoDTO aplicativo, Date dataInicio, Date dataFim,
            AssinaturaStatusEnum assinaturaStatusEnum) {
        this.id = id;
        this.cliente = cliente;
        this.aplicativo = aplicativo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = assinaturaStatusEnum;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public AplicativoDTO getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(AplicativoDTO aplicativo) {
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
        return "AssinaturaDTO [id=" + id + ", cliente=" + cliente + ", aplicativo=" + aplicativo + ", dataInicio="
                + dataInicio + ", dataFim=" + dataFim + ", status=" + status + "]";
    }
}
