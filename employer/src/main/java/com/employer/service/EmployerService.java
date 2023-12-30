package com.employer.service;

import com.employer.model.entity.Employer;
import com.employer.model.request.EmployerRequest;

public interface EmployerService {
    Employer getEmployerById(Long employerId);

    Employer saveOrUpdateEmployer(EmployerRequest employerRequest);
}
