package com.example.bakeryapi;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Bakery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pastry_seq")
    @SequenceGenerator(name = "pastry_seq", sequenceName = "pastry_seq", allocationSize = 1)
    private Long id;

    @Column(name = "Name", nullable = false, length = 100, unique = true)
    private String name;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "Avaliability",nullable = false)
    private boolean available;



}
