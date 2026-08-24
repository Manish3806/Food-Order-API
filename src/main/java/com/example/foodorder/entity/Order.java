package com.example.foodorder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@NotBlank(message = "Customer name is required")
	private String customerName;
	@NotBlank(message = "Food item cannot be empty")
	private String foodItem;
	@Min(value = 1, message = "Quantity must be at least 1")
	private Integer quantity;
	@NotNull(message = "Price is mandatory")
	private Double price;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}