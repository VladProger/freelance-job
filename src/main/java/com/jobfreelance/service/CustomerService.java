package com.jobfreelance.service;

import com.jobfreelance.dto.CustomerDetailsDto;
import com.jobfreelance.entity.CustomerDetailsEntity;
import com.jobfreelance.exception.AlreadyExistException;
import com.jobfreelance.exception.BadRequestException;
import com.jobfreelance.repository.CustomerDetailsRepository;
import com.jobfreelance.translator.CustomerDetailsTranslator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Objects;
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
        saveDetails(customerDetailsTranslator.translateToEntity(customerDetailsDto));
    }

    public void updateCustomerInfo(CustomerDetailsDto detailsDto){
        CustomerDetailsEntity entity = customerDetailsRepository.getByCustomerUuid(detailsDto.getCustomerUuid());
        if(entity==null)
            throw new BadRequestException("No such user found");
        customerDetailsTranslator.updateEntityByDto(detailsDto, entity);

        saveDetails(entity);
    }

    private void saveDetails(CustomerDetailsEntity entity){
        try {
            customerDetailsRepository.save(entity);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getMessage());

            if (Objects.requireNonNull(e.getMessage()).contains("customer_details.email_UNIQUE")) {
                throw new AlreadyExistException("This email already exists");
            } else if ((Objects.requireNonNull(e.getMessage()).contains("customer_details.pnohe_number_UNIQUE"))) {
                throw new AlreadyExistException("This phone number already exists");
            }
            throw new AlreadyExistException("Something went wrong. Please try again");
        }
    }
}