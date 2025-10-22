package com.example.bakeryapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BakeryRepository extends JpaRepository<Pastry,Long> {

    Pastry findByName(String name);
    List<Pastry> findByPriceLessThan(double price);
    List<Pastry> findByAvailableIsTrue();
    List<Pastry> findAll();
}
