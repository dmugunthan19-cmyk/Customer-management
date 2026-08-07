package com.Customer.and.Order.Management.REST.API.controller;

import com.Customer.and.Order.Management.REST.API.dto.Order;
import com.Customer.and.Order.Management.REST.API.dto.OrderDto;
import com.Customer.and.Order.Management.REST.API.service.OrderService;
import com.Customer.and.Order.Management.REST.API.utility.Constant;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        System.out.println("printed customer service");
    }

    @PostMapping("/create-order")
    public String addOrder(@Valid @RequestBody Order orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/get-all-order")
    public List<OrderDto> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/get-particular-order/{userId}")
    public OrderDto getOrder(@PathVariable Long userId) {
        return orderService.getOrder(userId);
    }

    @DeleteMapping("/delete-particular-order/{userId}")
    public String deleteOrder(@PathVariable Long userId) {
        return orderService.deleteOrder(userId);
    }

    @PutMapping("/update-particular-order/{id}")
    public String updateOder(@Valid @RequestBody OrderDto orderDto, @PathVariable("id") Long id) {
        return orderService.updateOrder(orderDto, id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderDto>> searchStatus(@RequestParam("status")  List<Constant.UserStatus> status) {
        System.out.println(status);
        List<OrderDto> findStatus = orderService.getStatus(status);
        if (!findStatus.isEmpty()) {
            return ResponseEntity.ok(findStatus);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}

