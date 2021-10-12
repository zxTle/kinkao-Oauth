package th.ac.ku.eateat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.eateat.model.Restuarant;
import th.ac.ku.eateat.services.RestaurantServices;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantServices service;

    @GetMapping
    public String getRestaurants(Model model) {
        model.addAttribute("restaurants", service.getAll());
        return "restaurant";
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "restaurant-add";
    }

    @PostMapping("/add")
    public String addRestaurant(@ModelAttribute Restuarant restaurant, Model model) {
        service.addRestaurant(restaurant);
        return "redirect:/restaurant";
    }
}