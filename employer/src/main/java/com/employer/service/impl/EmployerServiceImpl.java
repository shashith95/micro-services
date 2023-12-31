package com.employer.service.impl;

import com.employer.exception.DataNotFoundException;
import com.employer.mapper.EntityDtoMapper;
import com.employer.model.entity.Employer;
import com.employer.model.request.EmployerRequest;
import com.employer.repository.EmployerRepository;
import com.employer.service.EmployerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    private static final Logger logger = LoggerFactory.getLogger(EmployerServiceImpl.class);
    private final EmployerRepository employerRepository;
    private final EntityDtoMapper entityDtoMapper;

    public EmployerServiceImpl(EmployerRepository employerRepository, EntityDtoMapper entityDtoMapper) {
        this.employerRepository = employerRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public Employer getEmployerById(Long employerId) {

        return employerRepository.findById(employerId)
                .orElseThrow(() -> new DataNotFoundException("No employer found for id: " + employerId, "1000"));
    }

    @Override
    public Employer saveOrUpdateEmployer(EmployerRequest employerRequest) {
        Employer savedEmployer = employerRepository.save(entityDtoMapper.employerDtoToEntity(employerRequest));
        logger.info("Employer saved successfully with ID: {}", savedEmployer.getId());

        return savedEmployer;
    }
}
