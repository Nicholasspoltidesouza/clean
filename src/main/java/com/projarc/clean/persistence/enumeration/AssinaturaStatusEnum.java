package com.projarc.clean.persistence.enumeration;

public enum AssinaturaStatusEnum {
    ATIVA(0),
    CANCELADA(1);

    private Integer status;

    AssinaturaStatusEnum(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
