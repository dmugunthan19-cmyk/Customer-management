package com.Customer.and.Order.Management.REST.API.service;

import com.Customer.and.Order.Management.REST.API.dto.Order;
import com.Customer.and.Order.Management.REST.API.dto.OrderDto;
import com.Customer.and.Order.Management.REST.API.utility.Constant;

import java.util.List;

public interface OrderService {
    String createOrder(Order orderDto);

    List<OrderDto> getAllOrder();

    OrderDto getOrder(Long userId);

    String deleteOrder(Long userId);

    String updateOrder(OrderDto orderDto, Long orderId);

    List<OrderDto> getStatus(List<Constant.UserStatus> a);

}
