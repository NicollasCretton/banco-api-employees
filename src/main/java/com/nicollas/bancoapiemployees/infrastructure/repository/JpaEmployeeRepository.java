package com.nicollas.bancoapiemployees.infrastructure.repository;



import com.nicollas.bancoapiemployees.domain.model.Employee;
import com.nicollas.bancoapiemployees.domain.ports.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JpaEmployeeRepository implements EmployeeRepository {
    // Este será substituído futuramente por um repositório JPA real
    private final Map<Long, Employee> bancoEmMemoria = new HashMap<>();
    private Long idAtual = 1L;

    @Override
    public Employee save(Employee employee) {
        employee.setId(idAtual++);
        bancoEmMemoria.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(bancoEmMemoria.values());
    }

    @Override
    public void deleteById(Long id) {
        bancoEmMemoria.remove(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(bancoEmMemoria.get(id));
    }
}
