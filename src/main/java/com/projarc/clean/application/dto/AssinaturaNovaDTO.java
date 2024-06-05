package com.projarc.clean.application.dto;

public class AssinaturaNovaDTO {
    private Long codigoCliente;
    private Long codigoAplicativo;

    public AssinaturaNovaDTO(Long codigoCliente, Long codigoAplicativo) {
        this.codigoCliente = codigoCliente;
        this.codigoAplicativo = codigoAplicativo;
    }

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Long getCodigoAplicativo() {
        return codigoAplicativo;
    }

    public void setCodigoAplicativo(Long codigoAplicativo) {
        this.codigoAplicativo = codigoAplicativo;
    }

    @Override
    public String toString() {
        return "AssinaturaNovaDTO [codigoAplicativo=" + codigoAplicativo + ", codigoCliente=" + codigoCliente + "]";
    }
}
