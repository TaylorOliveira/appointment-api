package com.eldorado.appointment.payload.appointment;

import com.eldorado.appointment.model.Appointment;
import com.eldorado.appointment.payload.doctor.DoctorResponse;

import java.util.Date;

public class AppointmentResponse {

    private Long id;

    private DoctorResponse doctorResponse;

    public AppointmentResponse(Appointment appointment){
        this.id = appointment.getId();
        this.doctorResponse = new DoctorResponse(appointment.getDoctor());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorResponse getDoctorResponse() {
        return doctorResponse;
    }

    public void setDoctorResponse(DoctorResponse doctorResponse) {
        this.doctorResponse = doctorResponse;
    }
}
