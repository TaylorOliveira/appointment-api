package com.eldorado.appointment.service;

import com.eldorado.appointment.model.Doctor;
import com.eldorado.appointment.payload.doctor.DoctorRequest;
import com.eldorado.appointment.payload.doctor.DoctorResponse;
import com.eldorado.appointment.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorResponse> listDoctorResponse = new ArrayList<DoctorResponse>();
        for (Doctor doctor : doctors) {
            listDoctorResponse.add(new DoctorResponse(doctor));
        }
        return listDoctorResponse;
    }

    public DoctorResponse createDoctor(DoctorRequest doctorRequest) {
        Doctor doctor = new Doctor(doctorRequest);
        doctorRepository.save(doctor);
        return new DoctorResponse(doctor);
    }

    public void deleteAll(){
        doctorRepository.deleteAll();;
    }
}
