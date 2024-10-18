package com.sales.management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date creationDate;
    private String seller;
    private double total;
    @OneToMany(mappedBy = "sales",cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
