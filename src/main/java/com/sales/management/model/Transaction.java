package com.sales.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Sales sales;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Product product;
    private double price;
    private int quantity;

}
