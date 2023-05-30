package com.example.important_shop.service;

import com.example.important_shop.entity.Cart;
import com.example.important_shop.entity.Orders;
import com.example.important_shop.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    List<Orders> findOrdersByUser(User user);
    Optional<Orders> findById(int id);

    void addOrders(Orders orders,User user);

    void deleteById(int id);
}
