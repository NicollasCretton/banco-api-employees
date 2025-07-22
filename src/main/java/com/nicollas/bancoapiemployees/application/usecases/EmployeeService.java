package com.nicollas.bancoapiemployees.application.usecases;

import com.nicollas.bancoapiemployees.domain.model.Employee;
import com.nicollas.bancoapiemployees.domain.ports.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> listAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }
}
