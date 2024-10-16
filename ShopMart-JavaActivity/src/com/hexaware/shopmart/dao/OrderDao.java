package com.hexaware.shopmart.dao;

import java.util.List;

import com.hexaware.shopmart.entity.Order;

public interface OrderDao {

	void addOrder(Order order);
    List<Order> getOrderHistory(String userID);
}
