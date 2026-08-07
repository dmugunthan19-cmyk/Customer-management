package com.Customer.and.Order.Management.REST.API.controller;

import com.Customer.and.Order.Management.REST.API.dto.Customer;
import com.Customer.and.Order.Management.REST.API.dto.CustomerDto;
import com.Customer.and.Order.Management.REST.API.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
        System.out.println("This is for testing");
    }
    

    @PostMapping("/create-customer")
    public String addUser(@Valid @RequestBody CustomerDto customerDto) {

        return customerService.createData(customerDto);
    }

    @GetMapping("/get-all-customer")
    public List<CustomerDto> getAllUser(){
        return customerService.getAllUser();
    }

    @GetMapping("/get-particular-customer/{userId}")
    public Customer getUser(@PathVariable Long userId){
        return customerService.getUser(userId);
    }

    @DeleteMapping("/delete-particular-customer/{userId}")
    public void deleteUser(@PathVariable Long userId){
//        return customerService.deleteData(userId);
        System.out.println(customerService.deleteData(userId));
    }

    @PutMapping("/update-particular-customer/{id}")
    public String updateUserName(@RequestBody CustomerDto customerDto,@PathVariable ("id") Long id) {
        return customerService.updateData(customerDto,id);
    }
}
