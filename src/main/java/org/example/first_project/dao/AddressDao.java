package org.example.first_project.dao;

import lombok.RequiredArgsConstructor;
import org.example.first_project.model.dto.AddressDto;
import org.example.first_project.model.entity.Address;
import org.example.first_project.model.mapper.AddressMapper;
import org.example.first_project.repository.AddressRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressDao {
    private final AddressRepo addressRepo;
    private final AddressMapper addressMapper;

    public AddressDto update(AddressDto addressDto){
        Address entity =addressMapper.toEntity(addressDto);
        entity=addressRepo.save(entity);
        return addressMapper.toDto(entity);
    }
    public Optional<Address> findById(Long id){

        return addressRepo.findById(id);
    }

    public AddressDto createAddress(Address address) {
       address=addressRepo.save(address);
        return addressMapper.toDto(address);
    }
    public List<Address> getAll(){
        return addressRepo.findAll();
    }

    public boolean isExist(Long  id){
        return addressRepo.existsById(id);

    }
    public void deleteAddressById(Long id) {
        addressRepo.deleteById(id);
    }
}
