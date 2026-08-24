package com.example.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorder.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}