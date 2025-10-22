package com.example.bakeryapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bakery")
public class BakeryController {
    private List<Pastry> pastries;

    BakeryService bakeryService;

    public BakeryController(BakeryService bakeryService){
        this.bakeryService = bakeryService;
        pastries = new ArrayList<>();
//        Pastry pastry1 = new Pastry(null,"Szarlotka",23.99,true);
//        Pastry pastry2 = new Pastry(null,"Cynamonka",7.99,true);
//        Pastry pastry3 = new Pastry(null,"Pączek z różą", 4.99 , false);
//        bakeryService.savePastry(pastry1);
//        bakeryService.savePastry(pastry2);
//        bakeryService.savePastry(pastry3);
    }

    @GetMapping
    public String getAllPastries(Model model){
        List<Pastry> pastries = bakeryService.getAllPastries();
        model.addAttribute("pastries", pastries);
        model.addAttribute("newPastry", new Pastry());
        return "pastry";
    }

    @GetMapping("/available")
    public String getAvailablePastries(Model model) {
        List<Pastry> availablePastries = bakeryService.getAvailablePastries();
        model.addAttribute("pastries", availablePastries);
        model.addAttribute("newPastry", new Pastry());
        return "pastry";
    }


    @PostMapping("add-pastry")
    public String addPastry(@ModelAttribute Pastry pastry){
        bakeryService.savePastry(pastry);
        return "redirect:/bakery";
    }


    @GetMapping("/edit/{id}")
    public String editPastry(@PathVariable Long id, Model model) {
        Pastry pastry = bakeryService.getPastryById(id);
        model.addAttribute("pastryToEdit", pastry);
        return "edit-pastry";
    }

    @GetMapping("/cheaper-than")
    public String getPastriesCheaperThan(@RequestParam double price, Model model) {
        List<Pastry> filteredPastries = bakeryService.getPastriesCheaperThan(price);
        model.addAttribute("pastries", filteredPastries);
        model.addAttribute("newPastry", new Pastry());
        return "pastry";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePastry(@PathVariable Long id) {
        bakeryService.deletePastry(id);
        return "redirect:/bakery";
    }


    @PutMapping("/update")
    public String updatePastry(@ModelAttribute Pastry pastry) {
        bakeryService.savePastry(pastry);
        return "redirect:/bakery";
    }



}
