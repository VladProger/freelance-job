package com.jobfreelance.translator;

import com.jobfreelance.dto.CustomerDetailsDto;
import com.jobfreelance.entity.CustomerDetailsEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsTranslator {

    public CustomerDetailsDto translateToDto(CustomerDetailsEntity entity){
        if(entity==null)
            return null;
        return new CustomerDetailsDto(entity.getFirstName(), entity.getLastName(), entity.getSecondName(),
                entity.getAge(), entity.getEmail(), entity.getPhoneNumber(), entity.getIsEnabled(), entity.getCity(),
                entity.getCountry(), entity.getCustomerUuid());
    }

    public CustomerDetailsEntity translateToEntity(CustomerDetailsDto dto){
        if(dto == null)
            return null;
        CustomerDetailsEntity entity = new CustomerDetailsEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setSecondName(dto.getSecondName());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setIsEnabled(dto.getIsEnabled());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setCustomerUuid(dto.getCustomerUuid());
        return entity;
        /*return new CustomerDetailsEntity(null, dto.getFirstName(), dto.getLastName(), dto.getSecondName(),
                dto.getAge(), dto.getEmail(), dto.getPnoheNumber(), dto.getIsEnabled(), dto.getCity(),
                dto.getCountry(), dto.getCustomerUuid());*/
    }
}
