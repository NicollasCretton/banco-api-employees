package com.nicollas.bancoapiemployees.domain.ports;

import com.nicollas.bancoapiemployees.domain.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);
    List<Employee> findAll();
    void deleteById(Long id);
    Optional<Employee> findById(Long id);
}
