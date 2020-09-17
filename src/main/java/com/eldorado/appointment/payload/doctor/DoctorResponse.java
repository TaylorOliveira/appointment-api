package com.eldorado.appointment.payload.doctor;

import com.eldorado.appointment.model.Doctor;

public class DoctorResponse {

    private Long id;

    private String nome;

    private String crm;

    public DoctorResponse(Doctor doctor){
        this.id = doctor.getId();
        this.nome = doctor.getName();
        this.crm = doctor.getCrm();
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
