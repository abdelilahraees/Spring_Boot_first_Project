package org.example.first_project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.first_project.model.dto.AddressDto;
import org.example.first_project.model.entity.Address;
import org.example.first_project.repository.AddressRepo;
import org.example.first_project.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
@Slf4j
public class AddressController {
    private final AddressService addressService;
    private  final AddressRepo addressRepo;
    private int index;

    @PutMapping("/update")
    public AddressDto update(@RequestBody AddressDto address) {

        return addressService.updateAddress(address);
    }

    @PostMapping("/create")
    public AddressDto create(@RequestBody AddressDto address) {
        return addressService.updateAddress(address);
    }

    @GetMapping("/get-address/{id}")
    public Optional<AddressDto> getAddress(@PathVariable Long id) {
        log.info("id = {}", id);
        return addressService.findById(id);
    }

    @GetMapping("/get-addresses")
    public List<AddressDto> getAddresses() {
        return addressService.getAllAddress();
    }


    @DeleteMapping("/delete/{id}")
    private boolean delete(@PathVariable Long id) {
        return addressService.deleteAddressById(id);
    }


}
