package com.projarc.clean.application.dto;

public class AssinaturaDTO {

    private Long id;
    private ClienteDTO cliente;
    private AplicativoDTO aplicativo;
    private String dataInicio;
    private String dataFim;
    private String status;

    public AssinaturaDTO(Long id, ClienteDTO cliente, AplicativoDTO aplicativo, String dataInicio, String dataFim,
            String status) {
        this.id = id;
        this.cliente = cliente;
        this.aplicativo = aplicativo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;

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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AssinaturaDTO [id=" + id + ", cliente=" + cliente + ", aplicativo=" + aplicativo + ", dataInicio="
                + dataInicio + ", dataFim=" + dataFim + ", status=" + status + ", getId()=" + getId()
                + ", getCliente()=" + getCliente() + ", getAplicativo()=" + getAplicativo() + ", getDataInicio()="
                + getDataInicio() + ", getDataFim()=" + getDataFim() + ", getStatus()=" + getStatus() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
