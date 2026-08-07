package com.Customer.and.Order.Management.REST.API.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {

    @NotNull(message = "amount is required")
    private Double amount;
    @NotNull(message = "Order date is required")
    private LocalDate orderDate;
    private Long customerId;
}
