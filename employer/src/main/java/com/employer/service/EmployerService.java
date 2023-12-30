package com.employer.service;

import com.employer.model.common.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface EmployerService {
    ResponseEntity<ApiResponse> getEmployerById(Long employerId);
}
