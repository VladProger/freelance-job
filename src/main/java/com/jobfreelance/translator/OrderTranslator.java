package com.jobfreelance.translator;

import com.jobfreelance.dto.OrderDto;
import com.jobfreelance.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderTranslator {

    public OrderDto translateEntityToDto(OrderEntity entity) {
        return OrderDto.builder()
                .adress(entity.getAdress())
                .customerUuid(entity.getCustomerUuid())
                .description(entity.getDescription())
                .endDate(entity.getEndDate())
                .hackworkerUuid(entity.getHackworkerUuid())
                .orderStatus(entity.getOrderStatus())
                .photoUrl(entity.getPhotoUrl())
                .price(entity.getPrice())
                .build();
    }

    public OrderEntity translateDtoToEntity(OrderDto orderDto) {
        return OrderEntity.builder()
                .adress(orderDto.getAdress())
                .customerUuid(orderDto.getCustomerUuid())
                .description(orderDto.getDescription())
                .endDate(orderDto.getEndDate())
                .hackworkerUuid(orderDto.getHackworkerUuid())
                .orderStatus(orderDto.getOrderStatus())
                .photoUrl(orderDto.getPhotoUrl())
                .price(orderDto.getPrice())
                .build();
    }
}
