package org.example.first_project.controller;

import org.example.first_project.model.dto.AddressDto;
import org.example.first_project.model.entity.Address;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressController {
    @PostMapping("/address")
    private AddressDto create(@RequestBody AddressDto address) {

        System.out.println(address.getCity());
        return address;
    }

}
