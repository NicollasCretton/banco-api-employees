package com.nicollas.bancoapiemployees.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String home() {
        return "🚀 API Employees está ativa! Acesse /swagger-ui.html";
    }
}
