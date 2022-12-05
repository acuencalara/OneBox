package com.example.onebox.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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
