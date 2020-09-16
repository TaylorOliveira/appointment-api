package com.eldorado.appointment.model;

import com.eldorado.appointment.payload.appointment.AppointmentRequest;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @NotNull
    @Column(name = "apponintment_time")
    private Instant apponintmentTime;

    public Appointment(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Instant getApponintmentTime() {
        return apponintmentTime;
    }

    public void setApponintmentTime(Instant apponintmentTime) {
        this.apponintmentTime = apponintmentTime;
    }
}
