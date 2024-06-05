package com.projarc.clean.application.dto;

import java.util.Date;

import com.projarc.clean.persistence.entity.Assinatura;
import com.projarc.clean.persistence.enumeration.PagamentoStatusEnum;

public class PagamentoDTO {
    private Long id;
    private Assinatura assinatura;
    private Float valorPago;
    private Date dataPagamento;
    private String promocao;
    private PagamentoStatusEnum status;

    public PagamentoDTO(Long id, Assinatura assinatura, Float valorPago, Date dataPagamento, String promocao,
            PagamentoStatusEnum status) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.status = status;
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

    public PagamentoStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PagamentoStatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PagamentoDTO [id=" + id + ", assinatura=" + assinatura + ", valorPago=" + valorPago + ", dataPagamento="
                + dataPagamento + ", promocao=" + promocao + ", status=" + status + "]";
    }
}
