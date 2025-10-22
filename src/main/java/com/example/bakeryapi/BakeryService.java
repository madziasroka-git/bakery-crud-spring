package com.example.bakeryapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BakeryService {
    private final BakeryRepository bakeryRepository;


    public BakeryService(BakeryRepository bakeryRepository){
        this.bakeryRepository = bakeryRepository;
    }

    public List<Pastry> getAllPastries() {
        return bakeryRepository.findAll();
    }

    public Pastry getPastryByName(String name) {
        return bakeryRepository.findByName(name);
    }

    public List<Pastry> getPastriesCheaperThan(double price) {
        return bakeryRepository.findAll().stream()
                .filter(pastry -> pastry.getPrice() < price)
                .sorted((pastry1, pastry2) -> Double.compare(pastry1.getPrice(), pastry2.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Pastry> getAvailablePastries() {
        return bakeryRepository.findByAvailableIsTrue();
    }

    public void savePastry(Pastry pastry) {
        bakeryRepository.save(pastry);
    }
    public void deletePastry(Long id) {
        bakeryRepository.deleteById(id);
    }

    public Pastry getPastryById(Long id) {
        return bakeryRepository.findById(id).orElse(null);
    }


}
