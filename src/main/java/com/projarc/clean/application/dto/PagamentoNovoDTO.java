package com.projarc.clean.application.dto;

public class PagamentoNovoDTO {

    private Long idAssinatura;
    private Double valorPago;
    private String promocao;

    public PagamentoNovoDTO() {
    }

    public PagamentoNovoDTO(Long idAssinatura, Double valorPago, String promocao) {
        this.idAssinatura = idAssinatura;
        this.valorPago = valorPago;
        this.promocao = promocao;
    }

    public Long getIdAssinatura() {
        return idAssinatura;
    }

    public void setIdAssinatura(Long idAssinatura) {
        this.idAssinatura = idAssinatura;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "PagamentoNovoDTO [idAssinatura=" + idAssinatura + ", valorPago=" + valorPago + ", promocao=" + promocao
                + "]";
    }
}
