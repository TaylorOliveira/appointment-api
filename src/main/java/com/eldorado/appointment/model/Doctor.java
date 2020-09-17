package com.eldorado.appointment.model;

import com.eldorado.appointment.payload.doctor.DoctorRequest;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "crm", unique = true)
    private String crm;

    @NotNull
    @Column(name = "name")
    private String name;

    public Doctor() { }

    public Doctor(DoctorRequest doctorRequest) {
        this.setCrm(doctorRequest.getCrm());
        this.setName(doctorRequest.getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
