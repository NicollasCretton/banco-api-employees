package com.nicollas.bancoapiemployees.infrastructure.controller;

import com.nicollas.bancoapiemployees.application.usecases.EmployeeService;
import com.nicollas.bancoapiemployees.domain.model.Employee;
import com.nicollas.bancoapiemployees.infrastructure.controller.dto.EmployeeRequestDTO;
import com.nicollas.bancoapiemployees.infrastructure.controller.dto.EmployeeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAll() {
        return service.listAll()
                .stream()
                .map(e -> new EmployeeResponseDTO(
                        e.getId(), e.getName(), e.getEmail(), e.getDepartment()
                )).collect(Collectors.toList());
    }

    @PostMapping
    public EmployeeResponseDTO create(@Valid @RequestBody EmployeeRequestDTO request) {
        Employee novo = new Employee(null, request.getName(), request.getEmail(), request.getDepartment());
        Employee criado = service.create(novo);
        return new EmployeeResponseDTO(
                criado.getId(), criado.getName(), criado.getEmail(), criado.getDepartment()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
