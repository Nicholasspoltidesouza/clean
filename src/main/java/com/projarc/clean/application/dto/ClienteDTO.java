package com.projarc.clean.application.dto;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", getId()=" + getId() + ", getNome()="
                + getNome() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }
}
