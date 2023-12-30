package com.employer.service.impl;

import com.employer.exception.DataNotFoundException;
import com.employer.model.entity.Employer;
import com.employer.model.request.EmployerRequest;
import com.employer.repository.EmployerRepository;
import com.employer.service.EmployerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.employer.util.EntityDtoMapper.mapDtoToEntity;

@Service
public class EmployerServiceImpl implements EmployerService {
    private static final Logger logger = LoggerFactory.getLogger(EmployerServiceImpl.class);
    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer getEmployerById(Long employerId) {

        return employerRepository.findById(employerId)
                .orElseThrow(() -> new DataNotFoundException("No employer found for id: " + employerId, "1000"));
    }

    @Override
    public Employer saveOrUpdateEmployer(EmployerRequest employerRequest) {
        Employer savedEmployer = employerRepository.save(mapDtoToEntity(employerRequest, Employer.class));
        logger.info("Employer saved successfully with ID: {}", savedEmployer.getId());

        return savedEmployer;
    }
}
