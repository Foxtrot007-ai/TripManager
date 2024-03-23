package com.foxtrot.tripmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.foxtrot.tripmanager.domain.Client;
import com.foxtrot.tripmanager.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/client")
    public String viewClients(Model model) {
        List<Client> listOfClients = service.listAll();
        model.addAttribute("listOfClients", listOfClients);
        System.out.print("GET /client");
        return "client";
    }
    
    @GetMapping("/client/new")
    public String add(Model model) {
        model.addAttribute("client", new Client());
        return "addClient";
    }

    @RequestMapping(value = "/client/save", method=RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client std) {
        service.save(std);
        return "redirect:/client";
    }

    @RequestMapping("/client/edit/{id}")
    public ModelAndView showEditClientPage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("addClient");
        Client std = service.get(id); 
        mav.addObject("client", std);
        return mav;
    }
    
    @RequestMapping(value = "/client/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/client";
    }
    
    
}
