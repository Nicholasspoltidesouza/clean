package com.projarc.clean.application.dto;

import java.util.Date;

import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.PagamentoStatusEnum;

public class PagamentoDTO {
    private Long id;
    private Assinatura assinatura;
    private Double valorPago;
    private Date dataPagamento;
    private String promocao;
    private PagamentoStatusEnum status;
    private Double valorEstornado;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Long id, Assinatura assinatura, Double valorPago, Date dataPagamento, String promocao,
            PagamentoStatusEnum status, Double valorEstornado) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.status = status;
        this.valorEstornado = valorEstornado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
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

    public PagamentoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PagamentoStatusEnum status) {
        this.status = status;
    }

    public Double getValorEstornado() {
        return valorEstornado;
    }

    public void setValorEstornado(Double valorEstornado) {
        this.valorEstornado = valorEstornado;
    }

    @Override
    public String toString() {
        return "PagamentoDTO [id=" + id + ", assinatura=" + assinatura + ", valorPago=" + valorPago + ", dataPagamento="
                + dataPagamento + ", promocao=" + promocao + ", status=" + status + ", valorEstornado=" + valorEstornado
                + "]";
    }
}
