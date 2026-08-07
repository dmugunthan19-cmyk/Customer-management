package com.Customer.and.Order.Management.REST.API.service;

import com.Customer.and.Order.Management.REST.API.dto.Order;
import com.Customer.and.Order.Management.REST.API.dto.OrderDto;
import com.Customer.and.Order.Management.REST.API.entity.CustomerEntity;
import com.Customer.and.Order.Management.REST.API.entity.OrderEntity;
import com.Customer.and.Order.Management.REST.API.exception.ResourceNotFoundException;
import com.Customer.and.Order.Management.REST.API.repository.CustomerRepository;
import com.Customer.and.Order.Management.REST.API.repository.OrderRepository;
import com.Customer.and.Order.Management.REST.API.utility.Constant;
import com.Customer.and.Order.Management.REST.API.utility.MapperUtility;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public String createOrder(Order orderDto) {
        validation(orderDto);
        CustomerEntity customerEntity = getCustomerEntity(orderDto.getCustomerId());
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderNumber(UUID.randomUUID());
        orderEntity.setAmount(orderDto.getAmount());
        orderEntity.setOrderDate(orderDto.getOrderDate());
        orderEntity.setStatus(Constant.UserStatus.DELIVERED);
        orderEntity.setCustomerEntity(customerEntity);
        orderRepository.save(orderEntity);
        return "order details has been added";
    }

    private CustomerEntity getCustomerEntity(Long customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer id with" + customerId + "is not found"));
        return customerEntity;
    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<OrderEntity> OrdersEntityList = orderRepository.findAll();
        return OrdersEntityList.stream().map(MapperUtility::orderEntityToOrderDto).toList();
    }

    @Override
    public OrderDto getOrder(Long userId) {
        OrderEntity user = getUser(userId);
        OrderDto obj = new OrderDto();
        obj.setAmount(user.getAmount());
        obj.setOrderNumber(user.getOrderNumber());
        obj.setOrderDate(user.getOrderDate());
        obj.setStatus(user.getStatus());
        obj.setCustomerId(user.getCustomerEntity().getId());
        return obj;
    }

    private OrderEntity getUser(Long userId) {
        return orderRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Order not found with : " + userId + " "));

    }

    @Override
    public String deleteOrder(Long userId) {
        orderRepository.deleteById(userId);
        return "The order data deleted successfully...";
    }

    @Override
    public String updateOrder(OrderDto orderDto, Long orderId) {
        getCustomerEntity(orderDto.getCustomerId());
        OrderEntity orderEntity = getUser(orderId);

        orderEntity.setAmount(orderDto.getAmount());
        orderEntity.setOrderDate(orderDto.getOrderDate());
        orderEntity.setStatus(orderDto.getStatus());
        orderRepository.save(orderEntity);
        return "Order updated successfully";
    }

    @Override
    public List<OrderDto> getStatus(List<Constant.UserStatus> searchText) {
        List<OrderEntity> oderList;
        if(searchText!=null) {
             oderList = orderRepository.getByStatusIn(searchText);
        }else {
            oderList = orderRepository.findAll();
        }
        return oderList.stream().map(MapperUtility::orderEntityToOrderDto).toList();
    }

    private static void validation(Order orderDto) {
        if (orderDto.getAmount() < 1) {
            throw new ValidationException("Minimum amount must be greater than 0");
        }
        if (orderDto.getOrderDate() == null) {
            throw new ValidationException("Must provide the Date");
        }
    }
}
