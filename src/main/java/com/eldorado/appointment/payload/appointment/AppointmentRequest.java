package com.eldorado.appointment.payload.appointment;

public class AppointmentRequest {

    private Long id;

    private Long doctorId;

    public AppointmentRequest() { }

    public AppointmentRequest(Long doctorId) {
        this.doctorId = doctorId;
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
}
