package com.eldorado.appointment.service;

import com.eldorado.appointment.exception.ResourceNotFoundException;
import com.eldorado.appointment.model.Appointment;
import com.eldorado.appointment.model.Doctor;
import com.eldorado.appointment.model.Patient;
import com.eldorado.appointment.payload.appointment.AppointmentRequest;
import com.eldorado.appointment.payload.appointment.AppointmentResponse;
import com.eldorado.appointment.repository.AppointmentRepository;
import com.eldorado.appointment.repository.DoctorRepository;
import com.eldorado.appointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest){
        Appointment appointment = new Appointment();
        loadData(appointment, appointmentRequest);
        appointmentRepository.save(appointment);
        return new AppointmentResponse(appointment);
    }

    public Appointment loadData(Appointment appointment, AppointmentRequest appointmentRequest){
        appointment.setApponintmentTime(appointmentRequest.getApponintmentTime());
        if(Objects.nonNull(appointmentRequest.getDoctorId())){
            Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id",
                            appointmentRequest.getDoctorId()));
            appointment.setDoctor(doctor);
        }

        if(Objects.nonNull(appointmentRequest.getPatientId())){
            Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
                    .orElseThrow(() -> new ResourceNotFoundException("Patient", "id",
                            appointmentRequest.getPatientId()));
            appointment.setPatient(patient);
        }

        return appointment;
    }

    public List<AppointmentResponse> getAllAppointments(){
        List<Appointment> listAppointments = appointmentRepository.findAll();
        List<AppointmentResponse> listAppointmentsResponse = new ArrayList<>();

        for(Appointment a : listAppointments){
            listAppointmentsResponse.add(new AppointmentResponse(a));
        }

        return listAppointmentsResponse;
    }
}
