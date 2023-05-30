package com.example.important_shop.repository;

import com.example.important_shop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUser_Id(int id);

}
