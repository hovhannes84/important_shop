package com.example.important_shop.repository;

import com.example.important_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer> {


}
