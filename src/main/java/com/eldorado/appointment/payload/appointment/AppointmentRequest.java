package com.eldorado.appointment.payload.appointment;

import java.util.Date;

public class AppointmentRequest {

    private Long id;

    private Long doctorId;

    private Long patientId;

    private Date apponintmentTime;

    public AppointmentRequest() { }

    public AppointmentRequest(Long doctorId, Long patientId, Date apponintmentTime) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.apponintmentTime = apponintmentTime;
    }

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

    public Date getApponintmentTime() {
        return apponintmentTime;
    }

    public void setApponintmentTime(Date apponintmentTime) {
        this.apponintmentTime = apponintmentTime;
    }
}
