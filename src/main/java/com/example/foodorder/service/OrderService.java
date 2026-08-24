package com.example.foodorder.service;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.foodorder.entity.Order;
import com.example.foodorder.repository.OrderRepository;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }
    public Order getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found with id: " + id
                ));
    }
    public Order createOrder(Order order) {
        return repository.save(order);
    }
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);

        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setFoodItem(order.getFoodItem());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setPrice(order.getPrice());

        return repository.save(existingOrder);
    }
    public Order patchOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);

        if (order.getCustomerName() != null) {
            existingOrder.setCustomerName(order.getCustomerName());
        }

        if (order.getFoodItem() != null) {
            existingOrder.setFoodItem(order.getFoodItem());
        }

        if (order.getQuantity() != null) {
            existingOrder.setQuantity(order.getQuantity());
        }

        if (order.getPrice() != null) {
            existingOrder.setPrice(order.getPrice());
        }

        return repository.save(existingOrder);
    }
    public void deleteOrder(Long id) {
        Order existingOrder = getOrderById(id);
        repository.delete(existingOrder);
    }

}