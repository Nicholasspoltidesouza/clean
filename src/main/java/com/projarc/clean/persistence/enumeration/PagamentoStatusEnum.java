package com.projarc.clean.persistence.enumeration;

public enum PagamentoStatusEnum {
    PAGO(1),
    PENDENTE(0);

    private Integer status;

    PagamentoStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}