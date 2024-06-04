package com.projarc.clean.persistence.entity;

import java.util.Date;

import com.projarc.clean.domain.models.PagamentoModel;

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

    public Pagamento(Long id, Assinatura assinatura, Float valorPago, Date dataPagamento, String promocao) {
        this.id = id;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public PagamentoModel toPagamentoModel() {
        return new PagamentoModel(this.id, this.assinatura.toAssinaturaModel(assinatura), this.valorPago, this.dataPagamento, this.promocao);
    }

    public static Pagamento fromPagamentoModel(PagamentoModel pagamentoModel) {
        return new Pagamento(
            pagamentoModel.getId(),
            Assinatura.fromAssinaturaModel(pagamentoModel.getAssinatura()),
            pagamentoModel.getValorPago(),
            pagamentoModel.getDataPagamento(),
            pagamentoModel.getPromocao()
        );
    }
}