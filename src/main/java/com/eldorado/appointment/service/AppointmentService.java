package com.eldorado.appointment.service;

import com.eldorado.appointment.exception.ResourceNotFoundException;
import com.eldorado.appointment.model.Appointment;
import com.eldorado.appointment.model.Doctor;
import com.eldorado.appointment.payload.appointment.AppointmentRequest;
import com.eldorado.appointment.payload.appointment.AppointmentResponse;
import com.eldorado.appointment.repository.AppointmentRepository;
import com.eldorado.appointment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest){
        Appointment appointment = new Appointment();
        loadData(appointment, appointmentRequest);
        appointmentRepository.save(appointment);
        return new AppointmentResponse(appointment);
    }

    public Appointment loadData(Appointment appointment, AppointmentRequest appointmentRequest){
        if(Objects.nonNull(appointmentRequest.getDoctorId())){
            Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id",
                            appointmentRequest.getDoctorId()));
            appointment.setDoctor(doctor);
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
