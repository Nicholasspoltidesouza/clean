package com.projarc.clean.application.dto;

import com.projarc.clean.domain.models.AplicativoModel;

public class AplicativoDTO {

    private Long id;
    private String nome;
    private double custoMensal;

    public AplicativoDTO(Long id, String nome, double custoMensal) {
        this.id = id;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "AplicativoDTO [id=" + id + ", nome=" + nome + ", custoMensal=" + custoMensal + ", getId()=" + getId()
                + ", getNome()=" + getNome() + ", getCustoMensal()=" + getCustoMensal() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public static AplicativoDTO fromModel(AplicativoModel a) {
        return new AplicativoDTO(a.getId(), a.getNome(), a.getCustoMensal());
    }
}
