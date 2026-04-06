package com.hospital.dto;

public class DoctorDTO {

    private Integer userId;
    private Integer departmentId;
    private String specialization;
    private String licenseNumber;
    private Integer yearsOfExperience;

    public DoctorDTO() {
    }

    public DoctorDTO(Integer userId, Integer departmentId, String specialization, String licenseNumber, Integer yearsOfExperience) {
        this.userId = userId;
        this.departmentId = departmentId;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}