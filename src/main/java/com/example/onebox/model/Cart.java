package com.example.onebox.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_date")
    private LocalDate creationdDate;
    @OneToMany
    private List<Product> product;

    public Cart(LocalDate creationdDate, List<Product> product) {
        this.creationdDate = creationdDate;
        this.product = product;
    }

    public Cart() {
    }
}
