package com.hospital.dto;

public class DepartmentDTO {

    private String name;
    private String description;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}