package com.projarc.clean.persistence.enumeration;

public enum PagamentoStatusEnum {
    PAGAMENTO_OK(1),
    VALOR_INCORRETO(0);

    private Integer status;

    PagamentoStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}