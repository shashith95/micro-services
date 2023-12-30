package com.employer.model.response;

public record EmployerResponse(Long employeeId,
                               String firstName,
                               String lastName,
                               String addressLineOne,
                               String addressLineTwo) {
}
