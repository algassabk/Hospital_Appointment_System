package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.createDoctor(doctorDTO);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Integer id, @RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctor(id, doctorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }
}