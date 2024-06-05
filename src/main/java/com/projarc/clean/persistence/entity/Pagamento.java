package com.projarc.clean.persistence.entity;

import java.util.Date;

import com.projarc.clean.domain.models.PagamentoModel;
import com.projarc.clean.persistence.enumeration.PagamentoStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assinatura_id")
    private Assinatura assinatura;

    @Column(name = "valor_pago")
    private Float valorPago;

    @Column(name = "data_pagamento")
    private Date dataPagamento;

    @Column(name = "promocao")
    private String promocao;

    @Column(name = "status")
    private PagamentoStatusEnum status;

    public Pagamento() {
    }

    public Pagamento(Long id, Assinatura assinatura, Float valorPago, Date dataPagamento, String promocao,
            PagamentoStatusEnum status) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.status = status;
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento) {
        return new PagamentoModel(
                pagamento.getId(),
                pagamento.getAssinatura().toAssinaturaModel(),
                pagamento.getValorPago(),
                pagamento.getDataPagamento(),
                pagamento.getPromocao(),
                pagamento.getStatus());
    }

    public static Pagamento fromPagamentoModel(PagamentoModel pagamentoModel) {
        return new Pagamento(
                pagamentoModel.getId(),
                Assinatura.fromAssinaturaModel(pagamentoModel.getAssinatura()),
                pagamentoModel.getValorPago(),
                pagamentoModel.getDataPagamento(),
                pagamentoModel.getPromocao(),
                pagamentoModel.getStatus());
    }
}