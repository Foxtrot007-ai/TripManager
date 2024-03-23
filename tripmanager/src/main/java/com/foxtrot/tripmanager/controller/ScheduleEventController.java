package com.foxtrot.tripmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.foxtrot.tripmanager.domain.*;
import com.foxtrot.tripmanager.service.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ScheduleEventController {
    @Autowired
    private ScheduleEventService scheduleService;

    @Autowired 
    private PlaceService placeService;

    @Autowired
    private TransportService transportService;


    @GetMapping("/schedule")
    public String viewSchedules(Model model) {
        List<Schedule> listOfSchedules = scheduleService.listAllSchedules();
        model.addAttribute("listOfSchedules", listOfSchedules);
        return "schedule";
    }
    
    @GetMapping("/schedule/new")
    public String add(Model model) {
        model.addAttribute("schedule", new Schedule());
        return "addSchedule";
    }

    @RequestMapping(value = "/schedule/save", method=RequestMethod.POST)
    public String saveSchedule(@ModelAttribute("schedule") Schedule std) {
        scheduleService.saveSchedule(std);
        return "redirect:/schedule";
    }

    @RequestMapping("/schedule/edit/{id}")
    public ModelAndView showEditSchedulePage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("editSchedule");

        Schedule std1 = scheduleService.getSchedule(id); 
        mav.addObject("schedule", std1);

        List<Event> std2 = scheduleService.listAllEventForSchedule(id);

        
        mav.addObject("listOfEvents", std2);
     
        return mav;
    }

    @RequestMapping(value = "/schedule/delete/{id}")
    public String deleteSchedule(@PathVariable(name = "id") int id) {
        scheduleService.deleteSchedule(id);
        return "redirect:/schedule";
    }

    @GetMapping("schedule/edit/{id}/new/{type}")
    public String addEvent(@PathVariable(name = "id") int id,@PathVariable(name = "type") String type, Model model) {
        model.addAttribute("event", new Event());

        model.addAttribute("newType", type);
        if(type == "TRANSPORT"){
            model.addAttribute("listOfTransports", transportService.listAll());
        }else if (type == "PLACE"){
            model.addAttribute("listOfPlaces", placeService.listAll());
        }
        
        model.addAttribute("scheduleId", id);

        return "addEvent";
    }

    @RequestMapping("/schedule/edit/{id}/save/{refID}")
    public String saveEvent(@PathVariable(name = "id") int id , @PathVariable(name = "refID") int refId, @ModelAttribute("event") Event std) {
        if(std.getType() == "TRANSPORT"){
            std.setInfo(transportService.get(refId).toString());
        }else if (std.getType() == "PLACE"){
            std.setInfo(placeService.get(refId).toString());
        }
        scheduleService.saveEvent(std);
        return "redirect:/schedule/edit/" + id;
    }
    
    @RequestMapping("/schedule/edit/{id}/delete/{eventId}")
    public String deleteEvent(@PathVariable(name = "id") int id, @PathVariable(name = "eventId") int eventId) {
        scheduleService.deleteEvent(eventId);
        return "redirect:/schedule/edit/" + id;
    }
}
