package com.jobfreelance.service;

import com.jobfreelance.dto.CustomerDetailsDto;
import com.jobfreelance.exception.AlreadyExistException;
import com.jobfreelance.repository.CustomerDetailsRepository;
import com.jobfreelance.translator.CustomerDetailsTranslator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Log4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDetailsRepository customerDetailsRepository;
    private final CustomerDetailsTranslator customerDetailsTranslator;

    public CustomerDetailsDto getCustomerDetailsByUuid(String ucdmId) {
        return customerDetailsTranslator.translateToDto(customerDetailsRepository.getByCustomerUuid(ucdmId));
    }

    public void createCustomerDetails(CustomerDetailsDto customerDetailsDto) {
        customerDetailsDto.setCustomerUuid(UUID.randomUUID().toString());
        customerDetailsDto.setIsEnabled(true);
        try {
            customerDetailsRepository.save(customerDetailsTranslator.translateToEntity(customerDetailsDto));
        } catch (DataIntegrityViolationException e) {
            log.error(e.getMessage());

            if (e.getMessage().contains("customer_details.email_UNIQUE")) {
                throw new AlreadyExistException("This email already exists");
            } else if (e.getMessage().contains("customer_details.pnohe_number_UNIQUE")) {
                throw new AlreadyExistException("This phone number already exists");
            }
            throw new AlreadyExistException("Something went wrong. Please try again");
        }
    }
}
