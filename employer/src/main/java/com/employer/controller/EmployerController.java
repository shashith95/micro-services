package com.employer.controller;

import com.employer.model.common.ApiResponse;
import com.employer.service.EmployerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employer")
public class EmployerController {
    private static final Logger logger = LoggerFactory.getLogger(EmployerController.class);
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getEmployerById(@RequestParam(value = "id") Long employerId) {
        logger.info("Get employer by ID: {} API triggered", employerId);
        return employerService.getEmployerById(employerId);
    }
}
