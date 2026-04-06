package com.hospital.service;

import com.hospital.dto.PatientDTO;
import com.hospital.model.Patient;
import com.hospital.model.User;
import com.hospital.repository.PatientRepository;
import com.hospital.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    public PatientService(PatientRepository patientRepository, UserRepository userRepository) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    public Patient createPatient(PatientDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElse(null);

        if (user == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setUser(user);
        patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        patient.setGender(dto.getGender());
        patient.setBloodType(dto.getBloodType());
        patient.setAddress(dto.getAddress());

        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(Integer id, PatientDTO dto) {
        Patient patient = patientRepository.findById(id).orElse(null);
        User user = userRepository.findById(dto.getUserId()).orElse(null);

        if (patient == null || user == null) {
            return null;
        }

        patient.setUser(user);
        patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        patient.setGender(dto.getGender());
        patient.setBloodType(dto.getBloodType());
        patient.setAddress(dto.getAddress());

        return patientRepository.save(patient);
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }
}