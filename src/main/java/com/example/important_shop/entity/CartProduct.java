package com.example.important_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_product")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;

}
