package com.jobfreelance.translator;

import com.jobfreelance.dto.CustomerDetailsDto;
import com.jobfreelance.entity.CustomerDetailsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerDetailsTranslator {

    private final CustomerDetailsMapper customerDetailsMapper;

    public CustomerDetailsDto translateToDto(CustomerDetailsEntity entity){
        if(entity==null)
            return null;
        return new CustomerDetailsDto(entity.getFirstName(), entity.getLastName(), entity.getSecondName(),
                entity.getAge(), entity.getEmail(), entity.getCity(), entity.getCountry(), UUID.fromString(entity.getCustomerUuid()),
                 entity.getPhotoUrl());
    }

    public CustomerDetailsEntity translateToEntity(CustomerDetailsDto dto){
        return new CustomerDetailsEntity(null, dto.getFirstName(), dto.getLastName(), dto.getSecondName(),
                dto.getAge(), dto.getEmail(), null, null, dto.getCity(),
                dto.getCountry(), dto.getCustomerUuid().toString(), dto.getPhotoUrl());
    }
    public void updateEntityByDto(CustomerDetailsDto dto, CustomerDetailsEntity entity){
        if(dto == null)
            return;
        customerDetailsMapper.map(dto, entity);
    }
}