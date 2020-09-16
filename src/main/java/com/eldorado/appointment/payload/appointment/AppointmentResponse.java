package com.eldorado.appointment.payload.appointment;

import com.eldorado.appointment.model.Appointment;
import com.eldorado.appointment.payload.doctor.DoctorResponse;
import com.eldorado.appointment.payload.patient.PatientResponse;

import java.time.Instant;

public class AppointmentResponse {

    private Long id;

    private DoctorResponse doctorResponse;

    private PatientResponse patientResponse;

    private Instant apponintmentTime;

    public AppointmentResponse(Appointment appointment){
        this.id = appointment.getId();
        this.doctorResponse = new DoctorResponse(appointment.getDoctor());
        this.patientResponse = new PatientResponse(appointment.getPatient());
        this.apponintmentTime = appointment.getApponintmentTime();
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

    public PatientResponse getPatientResponse() {
        return patientResponse;
    }

    public void setPatientResponse(PatientResponse patientResponse) {
        this.patientResponse = patientResponse;
    }

    public Instant getApponintmentTime() {
        return apponintmentTime;
    }

    public void setApponintmentTime(Instant apponintmentTime) {
        this.apponintmentTime = apponintmentTime;
    }
}
