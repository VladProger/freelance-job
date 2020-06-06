package com.jobfreelance.controller;

import com.jobfreelance.dto.CustomerDetailsDto;
import com.jobfreelance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{uuid}")
    public CustomerDetailsDto getUserDetailsById(@PathVariable UUID uuid){
        return customerService.getCustomerDetailsByUuid(uuid.toString());
    }

    @PostMapping("/create")
    public void createCustomerDetails(@RequestBody @Valid CustomerDetailsDto request){
        customerService.createCustomerDetails(request);
    }
}
