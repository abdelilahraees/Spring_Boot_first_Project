package org.example.first_project.service.imp;

import lombok.RequiredArgsConstructor;
import org.example.first_project.dao.AddressDao;
import org.example.first_project.model.dto.AddressDto;
import org.example.first_project.model.entity.Address;
import org.example.first_project.model.mapper.AddressMapper;
import org.example.first_project.service.AddressService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImp  implements AddressService {
    private final AddressDao addressDao;
    private final AddressMapper addressMapper;
    @Override
    public AddressDto updateAddress(AddressDto address) {
        return addressDao.update(address);
    }

    @Override
    public AddressDto createAddress(Address address) {
        return addressDao.createAddress(address);
    }

    @Override
    public Optional<AddressDto> findById(Long id) {
        if(addressDao.findById(id).isPresent()){
            Address address=addressDao.findById(id).get();
            return Optional.ofNullable(addressMapper.toDto(address));
        }else return Optional.ofNullable(null);

    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addresses =addressDao.getAll();
       return addresses.stream().map(addressMapper::toDto).toList();

    }

    public boolean isExist(Long id){
        return addressDao.isExist(id);
    }

    @Override
    public boolean deleteAddressById(Long id) {
        if(this.isExist(id)){
           try {
               addressDao.deleteAddressById(id);
               return true;
           }catch (Exception e){
               return false;
           }
        }else {
            return false;
        }
    }

    @Override
    public boolean isExistById(Long id) {
        return addressDao.isExist(id);
    }
}
