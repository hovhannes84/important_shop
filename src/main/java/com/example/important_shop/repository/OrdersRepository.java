package com.example.important_shop.repository;

import com.example.important_shop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findAllByUser_Id(int id);

}
