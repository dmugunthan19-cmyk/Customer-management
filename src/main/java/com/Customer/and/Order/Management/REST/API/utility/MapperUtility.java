package com.Customer.and.Order.Management.REST.API.utility;

import com.Customer.and.Order.Management.REST.API.dto.CustomerDto;
import com.Customer.and.Order.Management.REST.API.dto.OrderDto;
import com.Customer.and.Order.Management.REST.API.entity.CustomerEntity;
import com.Customer.and.Order.Management.REST.API.entity.OrderEntity;

public class MapperUtility {
    public static OrderDto orderEntityToOrderDto(OrderEntity entity){
        OrderDto orderDto =new OrderDto();
        orderDto.setStatus(entity.getStatus());
        orderDto.setOrderDate(entity.getOrderDate());
        orderDto.setOrderNumber(entity.getOrderNumber());
        orderDto.setCustomerId(entity.getCustomerEntity().getId());
        orderDto.setAmount(entity.getAmount());
        return orderDto;
    }

    public static CustomerDto customerEntityToCustomerDto(CustomerEntity entity){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(entity.getName());
        customerDto.setEmail(entity.getEmail());
        customerDto.setMobileNumber(entity.getMobileNumber());
        customerDto.setId(entity.getId());
        return customerDto;
    }
}
