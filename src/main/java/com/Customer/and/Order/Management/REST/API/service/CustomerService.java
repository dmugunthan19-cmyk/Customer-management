package com.Customer.and.Order.Management.REST.API.service;

import com.Customer.and.Order.Management.REST.API.dto.Customer;
import com.Customer.and.Order.Management.REST.API.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    String createData(CustomerDto customerDto);

    List<CustomerDto> getAllUser();

    Customer getUser(Long userId);

    String deleteData(Long userId);

    String updateData(CustomerDto customerDto, Long id);
}
