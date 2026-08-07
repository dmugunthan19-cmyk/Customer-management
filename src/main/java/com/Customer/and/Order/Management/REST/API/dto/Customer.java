package com.Customer.and.Order.Management.REST.API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Customer {

    private Long id;
    @NotBlank
    private String name;
    @NotNull(message = "email is required")
    private String email;
    @NotNull(message = "mobileNumber is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must have exactly 10 digits")
    private String mobileNumber;
}
