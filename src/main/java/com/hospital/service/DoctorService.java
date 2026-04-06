package com.hospital.service;

import com.hospital.dto.DoctorDTO;
import com.hospital.model.Department;
import com.hospital.model.Doctor;
import com.hospital.model.User;
import com.hospital.repository.DepartmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public DoctorService(DoctorRepository doctorRepository, UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }

    public Doctor createDoctor(DoctorDTO doctorDTO) {
        User user = userRepository.findById(doctorDTO.getUserId()).orElse(null);
        Department department = departmentRepository.findById(doctorDTO.getDepartmentId()).orElse(null);

        if (user == null || department == null) {
            return null;
        }

        Doctor doctor = new Doctor();
        doctor.setUser(user);
        doctor.setDepartment(department);
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setLicenseNumber(doctorDTO.getLicenseNumber());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());

        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Integer id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(Integer id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        User user = userRepository.findById(doctorDTO.getUserId()).orElse(null);
        Department department = departmentRepository.findById(doctorDTO.getDepartmentId()).orElse(null);

        if (doctor == null || user == null || department == null) {
            return null;
        }

        doctor.setUser(user);
        doctor.setDepartment(department);
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setLicenseNumber(doctorDTO.getLicenseNumber());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }
}