package com.Customer.and.Order.Management.REST.API.dto;

import com.Customer.and.Order.Management.REST.API.utility.Constant;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class OrderDto {
    private Double amount;
    private LocalDate orderDate;
    private UUID orderNumber;
    private Long customerId;
    private Constant.UserStatus status;
}
