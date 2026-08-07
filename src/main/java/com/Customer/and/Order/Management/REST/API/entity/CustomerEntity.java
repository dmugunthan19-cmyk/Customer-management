package com.Customer.and.Order.Management.REST.API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_details")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Column(name = "name")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "name  must be letter invalid name!!!")
    private String name;

    @Column(name = "email", unique = true)
    @Email(message = "Enter a valid Email")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Mobile number must have exactly 10 digits")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @OneToMany(mappedBy = "customerEntity")
    private List<OrderEntity> orderEntities;
}