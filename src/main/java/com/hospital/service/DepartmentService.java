package com.hospital.service;

import com.hospital.dto.DepartmentDTO;
import com.hospital.model.Department;
import com.hospital.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department updateDepartment(Integer id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            return null;
        }

        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}