package com.example.important_shop.service.impl;

import com.example.important_shop.entity.Orders;
import com.example.important_shop.entity.User;
import com.example.important_shop.repository.OrdersRepository;
import com.example.important_shop.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Override
    public List<Orders> findOrdersByUser(User user) {
        List<Orders> orders = ordersRepository.findAllByUser_Id(user.getId());
        return orders;
    }

    @Override
    public Optional<Orders> findById(int id) {
        return ordersRepository.findById(id);
    }

    @Override
    public void addOrders(Orders orders, User user) {
        orders.setUser(user);
        ordersRepository.save(orders);

    }

    @Override
    public void deleteById(int id) {
        ordersRepository.deleteById(id);

    }
}
