package com.foxtrot.tripmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.foxtrot.tripmanager.domain.Transport;
import com.foxtrot.tripmanager.service.TransportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class TransportController {
    @Autowired
    private TransportService service;

    @GetMapping("/transport")
    public String viewTransport(Model model) {
        List<Transport> listOfTransports = service.listAll();
        model.addAttribute("listOfTransports", listOfTransports);
        System.out.print("GET /");
        return "transport";
    }
    
    @GetMapping("/transport/new")
    public String add(Model model) {
        model.addAttribute("transport", new Transport());
        return "addTransport";
    }

    @RequestMapping(value = "/transport/save", method=RequestMethod.POST)
    public String saveTransport(@ModelAttribute("transport") Transport std) {
        service.save(std);
        return "redirect:/transport";
    }

    @RequestMapping("/transport/edit/{id}")
    public ModelAndView showEditTransportPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("addTransport");
        Transport std = service.get(id); 
        mav.addObject("transport", std);
        return mav;
    }
    
    @RequestMapping(value = "/transport/delete/{id}")
    public String deleteTransport(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/transport";
    }
    
    
}
