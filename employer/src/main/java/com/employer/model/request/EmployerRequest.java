package com.employer.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.Optional;

public record EmployerRequest(@JsonProperty("id") Optional<Long> employerId,
                              @NotBlank String firstName,
                              @NotBlank String lastName,
                              @JsonInclude(JsonInclude.Include.NON_EMPTY) String addressLineOne,
                              @JsonInclude(JsonInclude.Include.NON_EMPTY) String addressLineTwo) {
}
