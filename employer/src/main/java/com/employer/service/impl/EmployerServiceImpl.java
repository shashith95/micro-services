package com.employer.service.impl;

import com.employer.exception.DataNotFoundException;
import com.employer.model.common.ApiResponse;
import com.employer.model.entity.Employer;
import com.employer.model.response.EmployerResponse;
import com.employer.repository.EmployerRepository;
import com.employer.service.EmployerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.employer.util.EntityDtoMapper.mapEntityToDto;
import static com.employer.util.ResponseHandler.generateResponse;

@Service
public class EmployerServiceImpl implements EmployerService {
    private static final Logger logger = LoggerFactory.getLogger(EmployerServiceImpl.class);
    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public ResponseEntity<ApiResponse> getEmployerById(Long employerId) {
        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new DataNotFoundException("No employer found for id: " + employerId, "1000"));
        logger.info("Successfully retrieved employer with ID: {}", employerId);

        return generateResponse(HttpStatus.OK, "Employer Returned Successfully", "100",
                mapEntityToDto(employer, EmployerResponse.class));
    }
}
