package com.example.important_shop.service;

import com.example.important_shop.entity.Cart;
import com.example.important_shop.entity.User;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> findCartsByUser(User user);
    Optional<Cart> findById(int id);

    void addCart(User user);

    void deleteById(int id);
}
