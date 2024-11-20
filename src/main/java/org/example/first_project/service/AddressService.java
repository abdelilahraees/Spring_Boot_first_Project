package org.example.first_project.service;

import org.example.first_project.model.dto.AddressDto;
import org.example.first_project.model.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AddressService {
    AddressDto updateAddress(AddressDto address);
    AddressDto createAddress(Address address);
    Optional<AddressDto> findById(Long id);
    List<AddressDto> getAllAddress();

    boolean deleteAddressById(Long id);

    boolean isExistById(Long id);
}
