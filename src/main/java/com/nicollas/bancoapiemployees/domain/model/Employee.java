package com.nicollas.bancoapiemployees.domain.model;

import java.util.Objects;

public class Employee {
    private Long id;
    private String name;
    private String email;
    private String department;

    public Employee(Long id, String name, String email, String department) {
        // Aqui poderiam entrar validações de negócio (ex: email válido)
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // Igualdade baseada no ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
