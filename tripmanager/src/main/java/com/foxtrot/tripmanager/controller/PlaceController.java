package com.foxtrot.tripmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.foxtrot.tripmanager.domain.Place;
import com.foxtrot.tripmanager.service.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class PlaceController {
    @Autowired
    private PlaceService service;

    @GetMapping("/place")
    public String viewPlaces(Model model) {
        List<Place> listOfPlaces = service.listAll();
        model.addAttribute("listOfPlaces", listOfPlaces);
        System.out.print("GET /place");
        return "place";
    }
    
    @GetMapping("/place/new")
    public String add(Model model) {
        model.addAttribute("place", new Place());
        return "addPlace";
    }

    @RequestMapping(value = "/place/save", method=RequestMethod.POST)
    public String savePlace(@ModelAttribute("place") Place std) {
        service.save(std);
        return "redirect:/place";
    }

    @RequestMapping("/place/edit/{id}")
    public ModelAndView showEditPlacePage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("addPlace");
        Place std = service.get(id); 
        mav.addObject("place", std);
        return mav;
    }
    
    @RequestMapping(value = "/place/delete/{id}")
    public String deletePlace(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/place";
    }
    
    
}
