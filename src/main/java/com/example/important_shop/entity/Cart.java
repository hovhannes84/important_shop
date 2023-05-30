package com.example.important_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
}
