package com.jobfreelance.controller;


import com.jobfreelance.dto.OrderDto;
import com.jobfreelance.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("{ucdmId}")
    public OrderDto getOrderByCustomer(@PathVariable UUID ucdmId) {
        return orderService.getOrderByCustomer(ucdmId.toString());
    }

    @PutMapping
    public void saveOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }
}
