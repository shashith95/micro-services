package com.employer.controller;

import com.employer.model.common.ApiResponse;
import com.employer.model.entity.Employer;
import com.employer.model.request.EmployerRequest;
import com.employer.service.EmployerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.employer.mapper.EmployeeResponseMapper.mapEntityToDto;
import static com.employer.util.ResponseHandler.generateResponse;

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
        Employer employer = employerService.getEmployerById(employerId);

        return generateResponse(HttpStatus.OK, "Employer Returned Successfully", "100",
                mapEntityToDto(employer));
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public ResponseEntity<ApiResponse> saveOrUpdateEmployer(@Valid @RequestBody EmployerRequest employerRequest) {
        logger.info("Save or Update employer API triggered with request body: {}", employerRequest);
        Employer employer = employerService.saveOrUpdateEmployer(employerRequest);

        return generateResponse(employerRequest.employeeId().isEmpty() ? HttpStatus.CREATED : HttpStatus.OK,
                "Employer " + (employerRequest.employeeId().isEmpty() ? "Created" : "Updated") + " Successfully",
                "100",
                mapEntityToDto(employer));
    }
}
