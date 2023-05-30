package com.example.important_shop.service.impl;

import com.example.important_shop.entity.Cart;
import com.example.important_shop.entity.Type;
import com.example.important_shop.entity.User;
import com.example.important_shop.repository.CartRepository;
import com.example.important_shop.repository.OrdersRepository;
import com.example.important_shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final OrdersRepository ordersRepository;


    @Override
    public List<Cart> findCartsByUser(User user) {
        List<Cart> carts;
        if (user.getType() == Type.ADMIN){
            carts = cartRepository.findAll();
        }else {
            carts = cartRepository.findAllByUser_Id(user.getId());
        }
        return carts;
    }

    @Override
    public Optional<Cart> findById(int id) {
        return cartRepository.findById(id);

    }

    @Override
    public void addCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
    }

    @Override
    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }
}
