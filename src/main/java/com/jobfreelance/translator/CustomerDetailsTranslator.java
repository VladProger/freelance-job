package com.jobfreelance.translator;

import com.jobfreelance.dto.CustomerDetailsDto;
import com.jobfreelance.entity.CustomerDetailsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDetailsTranslator {

    private final CustomerDetailsMapper customerDetailsMapper;

    public CustomerDetailsDto translateToDto(CustomerDetailsEntity entity){
        if(entity==null)
            return null;
        return new CustomerDetailsDto(entity.getFirstName(), entity.getLastName(), entity.getSecondName(),
                entity.getAge(), entity.getEmail(), entity.getCity(), entity.getCountry(), entity.getCustomerUuid());
    }

    public CustomerDetailsEntity translateToEntity(CustomerDetailsDto dto){
        return new CustomerDetailsEntity(null, dto.getFirstName(), dto.getLastName(), dto.getSecondName(),
                dto.getAge(), dto.getEmail(), null, null, dto.getCity(),
                dto.getCountry(), dto.getCustomerUuid());
    }
    public void updateEntityByDto(CustomerDetailsDto dto, CustomerDetailsEntity entity){
        if(dto == null)
            return;
        customerDetailsMapper.map(dto, entity);
        /*CustomerDetailsEntity entity = new CustomerDetailsEntity();
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
        */
    }
}
