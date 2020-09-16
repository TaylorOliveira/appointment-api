package com.eldorado.appointment.payload.appointment;

import java.time.Instant;

public class AppointmentRequest {

    private Long id;

    private Long doctorId;

    private Long patientId;

    private Instant apponintmentTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Instant getApponintmentTime() {
        return apponintmentTime;
    }

    public void setApponintmentTime(Instant apponintmentTime) {
        this.apponintmentTime = apponintmentTime;
    }
}
