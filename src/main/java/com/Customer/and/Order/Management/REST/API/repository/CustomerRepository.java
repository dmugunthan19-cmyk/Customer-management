package com.Customer.and.Order.Management.REST.API.repository;

import com.Customer.and.Order.Management.REST.API.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity, Long>  {


}
