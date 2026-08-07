package com.Customer.and.Order.Management.REST.API.repository;


import com.Customer.and.Order.Management.REST.API.entity.OrderEntity;
import com.Customer.and.Order.Management.REST.API.utility.Constant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> getByStatusIn(
            List<Constant.UserStatus> a);

}