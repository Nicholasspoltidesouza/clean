package com.projarc.clean.domain.models;

import java.util.Date;

public class PagamentoModel {
    private Long id;
    private AssinaturaModel assinatura;
    private Float valorPago;
    private Date dataPagamento;
    private String promocao;

    public PagamentoModel(Long id, AssinaturaModel assinatura, Float valorPago, Date dataPagamento, String promocao) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AssinaturaModel getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(AssinaturaModel assinatura) {
        this.assinatura = assinatura;
    }

    public Float getValorPago() {
        return valorPago;
    }

    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "PagamentoModel{" +
                "id=" + id +
                ", assinatura=" + assinatura +
                ", valorPago=" + valorPago +
                ", dataPagamento=" + dataPagamento +
                ", promocao='" + promocao + '\'' +
                '}';
    }
}