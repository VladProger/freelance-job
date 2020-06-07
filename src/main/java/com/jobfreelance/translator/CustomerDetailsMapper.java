package com.jobfreelance.translator;

import com.jobfreelance.dto.CustomerDetailsDto;
import com.jobfreelance.entity.CustomerDetailsEntity;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsMapper extends BidirectionalMapper {
    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.classMap(CustomerDetailsDto.class, CustomerDetailsEntity.class)
        .fieldAToB("firstName", "firstName")
        .fieldAToB("lastName", "lastName")
        .fieldAToB("secondName", "secondName")
        .fieldAToB("age", "age")
        .fieldAToB("email", "email")
        .fieldAToB("customerUuid", "customerUuid")
        .fieldAToB("city", "city")
        .fieldAToB("country", "country");

    }
}
