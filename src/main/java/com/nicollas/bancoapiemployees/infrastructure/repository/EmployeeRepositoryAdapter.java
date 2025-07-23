package com.nicollas.bancoapiemployees.infrastructure.repository;

import com.nicollas.bancoapiemployees.domain.model.Employee;
import com.nicollas.bancoapiemployees.domain.ports.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryAdapter implements EmployeeRepository {

    private final EmployeeJpaRepository jpaRepository;

    public EmployeeRepositoryAdapter(EmployeeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity entity = toEntity(employee);
        EmployeeEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public List<Employee> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    private Employee toDomain(EmployeeEntity entity) {
        return new Employee(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getDepartment()
        );
    }

    private EmployeeEntity toEntity(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(employee.getId());
        entity.setName(employee.getName());
        entity.setEmail(employee.getEmail());
        entity.setDepartment(employee.getDepartment());
        return entity;
    }
}
