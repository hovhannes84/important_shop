package com.example.important_shop.repository;

import com.example.important_shop.entity.CartProduct;
import com.example.important_shop.entity.Product;
import com.example.important_shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CartProductRepository extends JpaRepository<CartProduct,Integer> {

    Optional<CartProduct> findByProduct(Product product);

    Optional<CartProduct> findFirstByProduct(Product product);


//    void delete(Optional<CartProduct> cartProduct);

}
