package com.eldorado.appointment.payload.doctor;

public class DoctorRequest {

    private Long id;

    private String nome;

    private String crm;

    public DoctorRequest(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
