package com.nicollas.bancoapiemployees.infrastructure.config;

import com.nicollas.bancoapiemployees.application.usecases.EmployeeService;
import com.nicollas.bancoapiemployees.domain.ports.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public EmployeeService employeeService(
            @Qualifier("employeeRepositoryAdapter") EmployeeRepository employeeRepository
    ) {
        return new EmployeeService(employeeRepository);
    }
}
