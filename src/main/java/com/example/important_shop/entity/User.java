package com.example.important_shop.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Type Type;


}