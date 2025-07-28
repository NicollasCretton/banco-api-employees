package com.nicollas.bancoapiemployees.domain.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Funcionário com ID " + id + " não encontrado.");
    }
}
