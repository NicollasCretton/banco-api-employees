package com.nicollas.bancoapiemployees.infrastructure.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeRequestDTO {

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "O departamento não pode ser vazio")
    private String department;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
