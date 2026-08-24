package com.example.foodorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.foodorder.entity.Order;
import com.example.foodorder.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }
    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order) {
        return service.createOrder(order);
    }
    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable Long id, @Valid @RequestBody Order order) {
        return service.updateOrder(id, order);
    }
    @PatchMapping("/orders/{id}")
    public Order patchOrder(@PathVariable Long id, @RequestBody Order order) {
        return service.patchOrder(id, order);
    }
    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return "Order deleted successfully";
    }
}