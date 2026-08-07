package com.Customer.and.Order.Management.REST.API.dto;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CustomerDto {

    private Long id;
    private String name;
    private String email;
    @Pattern(regexp = "\\d{10}", message = "Mobile number must have exactly 10 digits")
    private String mobileNumber;
}
