package com.projarc.clean.persistence.entity;

import java.util.Date;

import com.projarc.clean.application.dto.PagamentoDTO;
import com.projarc.clean.domain.models.PagamentoModel;
import com.projarc.clean.persistence.enumeration.PagamentoStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "pagamentos", uniqueConstraints = @UniqueConstraint(columnNames = { "id" }))
public class Pagamento {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assinatura_id")
    private Assinatura assinatura;

    @Column(name = "valor_pago")
    private Double valorPago;

    @Column(name = "data_pagamento")
    private Date dataPagamento;

    @Column(name = "promocao")
    private String promocao;

    @Column(name = "status")
    private PagamentoStatusEnum status;

    @Column(name = "valor_estornado")
    private Double valorEstornado;

    public Pagamento() {
    }

    public Pagamento(Long id, Assinatura assinatura, Double valorPago, Date dataPagamento, String promocao,
            PagamentoStatusEnum status, Double valorEstornado) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.status = status;
        this.valorEstornado = valorEstornado;
    }

    public static PagamentoModel toPagamentoModel(Pagamento pagamento) {
        return new PagamentoModel(
                pagamento.getId(),
                pagamento.getAssinatura().toAssinaturaModel(),
                pagamento.getValorPago(),
                pagamento.getDataPagamento(),
                pagamento.getPromocao(),
                pagamento.getStatus(), pagamento.getValorEstornado());
    }

    public static Pagamento fromPagamentoModel(PagamentoModel pagamentoModel) {
        return new Pagamento(
                pagamentoModel.getId(),
                Assinatura.fromAssinaturaModel(pagamentoModel.getAssinatura()),
                pagamentoModel.getValorPago(),
                pagamentoModel.getDataPagamento(),
                pagamentoModel.getPromocao(),
                pagamentoModel.getStatus(), pagamentoModel.getValorEstornado());
    }

    public static PagamentoDTO fromModelToDTO(PagamentoModel pagamentoModel) {
        return new PagamentoDTO(pagamentoModel.getId(), Assinatura.fromAssinaturaModel(pagamentoModel.getAssinatura()),
                pagamentoModel.getValorPago(), pagamentoModel.getDataPagamento(), pagamentoModel.getPromocao(),
                pagamentoModel.getStatus(), pagamentoModel.getValorEstornado());
    }
}