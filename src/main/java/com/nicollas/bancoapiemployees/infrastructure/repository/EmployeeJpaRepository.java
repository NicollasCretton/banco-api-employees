package com.nicollas.bancoapiemployees.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {
}
