package com.employer.mapper;

import com.employer.model.entity.Employer;
import com.employer.model.response.EmployerResponse;

public class EmployeeResponseMapper {

    private EmployeeResponseMapper() {
    }

    public static EmployerResponse mapEntityToDto(Employer employer) {

        return new EmployerResponse(employer.getId(), employer.getFirstName(), employer.getFirstName(),
                employer.getAddressLineOne(), employer.getAddressLineTwo());
    }
}
