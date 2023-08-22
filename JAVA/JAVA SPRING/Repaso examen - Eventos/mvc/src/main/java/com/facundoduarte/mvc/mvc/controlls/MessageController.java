package com.facundoduarte.mvc.mvc.controlls;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facundoduarte.mvc.mvc.models.Event;
import com.facundoduarte.mvc.mvc.models.Message;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.services.EventService;
import com.facundoduarte.mvc.mvc.services.MessageService;
import com.facundoduarte.mvc.mvc.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MessageController {
    private final MessageService messageService;
    private final EventService eventService;
    private final UserService userService;

    public MessageController(EventService eventService, UserService userService, MessageService messageService) {
        this.messageService = messageService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @RequestMapping(value = "/event/{eventId}/new-message", method = RequestMethod.POST)
    public String newMessage(@Valid @ModelAttribute("message") Message message,
            BindingResult result, @PathVariable("eventId") Long eventId,
            Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        if (user.equals(null)) {
            return "redirect:/";
        } else if (result.hasErrors()) {
            return "event";
        } else {
            Event event = eventService.findEventById(eventId);
            message.setUser(user);
            message.setEvent(event);
            event.getMessages().add(message);
            messageService.createMessage(message);
            return "redirect:/event/" + eventId;
        }
    }
}
