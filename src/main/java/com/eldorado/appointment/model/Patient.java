package com.eldorado.appointment.model;

import com.eldorado.appointment.payload.patient.PatientRequest;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "cpf", unique = true)
    private String cpf;

    @NotNull
    @Column(name = "name")
    private String name;

    public Patient(PatientRequest patientRequest) {
        this.id = patientRequest.getId();
        this.cpf = patientRequest.getCpf();
        this.name = patientRequest.getName();
    }

    public Patient() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
