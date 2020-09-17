package com.eldorado.appointment.controller;

import com.eldorado.appointment.payload.doctor.DoctorRequest;
import com.eldorado.appointment.payload.doctor.DoctorResponse;
import com.eldorado.appointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/doctor")
    public ResponseEntity<?> createDoctor(@Validated @RequestBody DoctorRequest doctorRequest) {
        DoctorResponse doctorResponse = doctorService.createDoctor(doctorRequest);
        return ResponseEntity.ok().body(doctorResponse);
    }

    @GetMapping("/listDoctors")
    public List<DoctorResponse> getAllDoctors() {

        return doctorService.getAllDoctors();
    }
}
