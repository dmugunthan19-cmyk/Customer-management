package com.Customer.and.Order.Management.REST.API.service;

import com.Customer.and.Order.Management.REST.API.dto.Customer;
import com.Customer.and.Order.Management.REST.API.dto.CustomerDto;
import com.Customer.and.Order.Management.REST.API.entity.CustomerEntity;
import com.Customer.and.Order.Management.REST.API.exception.ResourceNotFoundException;
import com.Customer.and.Order.Management.REST.API.repository.CustomerRepository;
import com.Customer.and.Order.Management.REST.API.utility.MapperUtility;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public String createData(CustomerDto customerDto) {
        validation(customerDto);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerDto.getName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setMobileNumber(customerDto.getMobileNumber());
        this.customerRepository.save(customerEntity);
        return "customer details has been added";
    }

    @Override
    public List<CustomerDto> getAllUser() {
        List<CustomerEntity> CustomersEntityList = customerRepository.findAll();
        return CustomersEntityList.stream().map(MapperUtility::customerEntityToCustomerDto).toList();
    }

    @Override
    public Customer getUser(Long userId) {
        CustomerEntity user = getCustomerEntity(userId, "Customer not found with this Id :");
        Customer object = new Customer();
        object.setId(user.getId());
        object.setName(user.getName());
        object.setEmail(user.getEmail());
        object.setMobileNumber(user.getMobileNumber());
        return object;
    }

    private CustomerEntity getCustomerEntity(Long userId, String message) {
        return customerRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(message + userId));
    }

    @Override
    public String deleteData(Long userId) {
        customerRepository.deleteById(userId);
        return "The user data deleted successfully...";
    }

    @Override
    public String updateData(CustomerDto customerDto, Long userId) {
        CustomerEntity userName = getCustomerEntity(userId, "customer not found with : ");
        validation(customerDto);
        userName.setName(customerDto.getName());
        userName.setEmail(customerDto.getEmail());
        userName.setMobileNumber(customerDto.getMobileNumber());
        customerRepository.save(userName);
        return "user updated succesfully";
    }

    private static void validation(CustomerDto customerDto) {
        if (customerDto.getMobileNumber() == null) {
            throw new ValidationException("Must provide the Mobile Number");
        }
        if (customerDto.getEmail() == null || customerDto.getEmail().isBlank()) {
            throw new ValidationException("Must provide the Email");
        }
        if (customerDto.getName() == null || customerDto.getName().isBlank()) {
            throw new ValidationException("Must provide the name");
        }
    }

}
