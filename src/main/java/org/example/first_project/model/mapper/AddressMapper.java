package org.example.first_project.model.mapper;

import org.example.first_project.model.dto.AddressDto;
import org.example.first_project.model.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressDto dto);

    Address toDto(Address entity);
}
