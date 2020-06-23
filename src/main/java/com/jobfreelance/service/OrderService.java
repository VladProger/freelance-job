package com.jobfreelance.service;

import com.jobfreelance.dto.OrderDto;
import com.jobfreelance.repository.OrderRepository;
import com.jobfreelance.translator.OrderTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderTranslator orderTranslator;

    public OrderDto getOrderByCustomer(String ucdmId) {
        return orderTranslator.translateEntityToDto(orderRepository.findByCustomerUuid(ucdmId));
    }

    public void addOrder(OrderDto orderDto) {
        orderRepository.save(orderTranslator.translateDtoToEntity(orderDto));
    }
}
