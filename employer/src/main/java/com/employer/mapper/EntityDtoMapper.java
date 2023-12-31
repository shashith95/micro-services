package com.employer.mapper;

import com.employer.model.entity.Employer;
import com.employer.model.request.EmployerRequest;
import com.employer.model.response.EmployerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface EntityDtoMapper {

    @Mapping(target = "employeeId", source = "id")
    EmployerResponse employerEntityToDto(Employer employer);

    @Mapping(target = "id", source = "employerId")
    Employer employerDtoToEntity(EmployerRequest employerRequest);

    /**
     * MapStruct will automatically use the map method when converting Optional<Long> to Long.
     *
     * @param value the optional value to map
     * @return the mapped Long value, or null if the optional is empty
     */
    default Long map(Optional<Long> value) {
        return value.orElse(null);
    }
}
