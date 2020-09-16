package com.eldorado.appointment.service;

import com.eldorado.appointment.model.Patient;
import com.eldorado.appointment.payload.patient.PatientRequest;
import com.eldorado.appointment.payload.patient.PatientResponse;
import com.eldorado.appointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponse> listPatientResponse = new ArrayList<PatientResponse>();
        for (Patient patient : patients) {
            listPatientResponse.add(new PatientResponse(patient));
        }
        return listPatientResponse;
    }

    public PatientResponse createPatient(PatientRequest patientRequest) {
        Patient patient = new Patient(patientRequest);
        patientRepository.save(patient);
        return new PatientResponse(patient);
    }
}
