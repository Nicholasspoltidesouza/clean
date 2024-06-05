package com.projarc.clean.application.dto;

public class AplicativoPatchDTO {

    private Double custoMensal;

    public AplicativoPatchDTO(Double custoMensal) {
        this.custoMensal = custoMensal;
    }

    public AplicativoPatchDTO() {
    }

    public Double custoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "AplicativoPatchDTO [custoMensal=" + custoMensal + "]";
    }

}
