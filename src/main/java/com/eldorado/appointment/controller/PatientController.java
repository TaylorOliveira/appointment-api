package com.eldorado.appointment.controller;

import com.eldorado.appointment.payload.doctor.DoctorRequest;
import com.eldorado.appointment.payload.doctor.DoctorResponse;
import com.eldorado.appointment.payload.patient.PatientRequest;
import com.eldorado.appointment.payload.patient.PatientResponse;
import com.eldorado.appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patient")
    public ResponseEntity<?> createPatient() {
        PatientResponse patientResponse = patientService.createPatient(
                new PatientRequest("JULIANA MATTOS", "04778667190"));
        return ResponseEntity.ok().body(patientResponse);
    }

    @GetMapping("/listPatients")
    public List<PatientResponse> getAllPatients() {
        return patientService.getAllPatients();
    }
}
