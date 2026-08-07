package com.Customer.and.Order.Management.REST.API.entity;


import com.Customer.and.Order.Management.REST.API.utility.Constant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "order_details")
public class OrderEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "orderNumber")
    private UUID orderNumber;

    @Column(name = "amount", precision = 5, nullable = false)
    private Double amount;

    @Column(name = "order_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Enter valid date")
    private LocalDate orderDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Constant.UserStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private CustomerEntity customerEntity;
}

