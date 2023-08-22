package com.facundoduarte.mvc.mvc.controlls;

import com.facundoduarte.mvc.mvc.models.Event;
import com.facundoduarte.mvc.mvc.models.State;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.services.EventService;
import com.facundoduarte.mvc.mvc.services.StateService;
import com.facundoduarte.mvc.mvc.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
    private final EventService eventService;
    private final UserService userService;
    private final StateService stateService;

    public EventController(EventService eventService, UserService userService, StateService stateService) {
        this.eventService = eventService;
        this.stateService = stateService;
        this.userService = userService;
    }

    @RequestMapping(value = "/index/createEvent", method = RequestMethod.POST)
    public String createEvent(@Valid @ModelAttribute("event") Event event,
            BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "index";
        } else {
            Long userId = (Long) session.getAttribute("userId");
            User user = userService.findUserById(userId);
            event.setHost(user);
            eventService.createEvent(event);
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/event/{id}/join", method = RequestMethod.POST)
    public String joinEvent(@PathVariable("id") Long eventId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Event event = eventService.findEventById(eventId);
        event.getGuests().add(user);
        event.setJoinedByCurrentUser(true);
        eventService.createEvent(event);
        return "redirect:/index";
    }

    @RequestMapping(value = "/event/{id}/cancel", method = RequestMethod.POST)
    public String cancelEvent(@PathVariable("id") Long eventId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Event event = eventService.findEventById(eventId);
        event.getGuests().remove(user);
        event.setJoinedByCurrentUser(false);
        eventService.createEvent(event);
        return "redirect:/index";
    }

    @GetMapping(value = "/event/{id}")
    public String showEventURL(@PathVariable("id") Long eventId, Model model) {
        Event event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "event";
    }

    @GetMapping(value = "/event/{id}/update")
    public String editEvent(@PathVariable("id") Long eventId, HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        Event event = eventService.findEventById(eventId);
        if (!event.getHost().equals(user)) {
            return "redirect:/index";
        } else {
            model.addAttribute("event", event);
            List<State> listStates = stateService.allStates();
            model.addAttribute("states", listStates);
            return "editEvent";
        }
    }

    @RequestMapping(value = "/event/{eventId}/update", method = RequestMethod.POST)
    public String updateEvente(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute("event") Event event) {

        Event eventUpdated = eventService.findEventById(eventId);
        eventService.updateEvent(eventUpdated, event);
        return "redirect:/index";

    }

}
