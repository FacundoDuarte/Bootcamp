package com.facundoduarte.mvc.mvc.controllers;

import com.facundoduarte.mvc.mvc.models.Project;
import com.facundoduarte.mvc.mvc.models.Task;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.services.ProjectService;
import com.facundoduarte.mvc.mvc.services.TaskService;
import com.facundoduarte.mvc.mvc.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;

    public TaskController(UserService userService, TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;

    }

    @GetMapping(value = "/projects/{projectId}/tasks")
    public String showTask(@PathVariable("projectId") Long id, HttpSession session,
            Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            Project actualProject = projectService.findProjectById(id);
            model.addAttribute("project", actualProject);
            List<Task> listTasks = taskService.tasksByProject(id);
            model.addAttribute("tasks", listTasks);
            model.addAttribute("task", new Task());
            return "tasks";
        }
    }

    @RequestMapping(value = "/projects/{projectId}/tasks", method = RequestMethod.POST)
    public String createTask(@PathVariable("projectId") Long id, @Valid @ModelAttribute("task") Task task,
            BindingResult result, HttpSession session, Model model) {
        if (result.hasErrors()) {
            return "tasks";
        } else {
            Long userId = (Long) session.getAttribute("userId");
            User user = userService.findUserById(userId);
            Project actualProject = projectService.findProjectById(id);
            task.setTaskCreator(user);
            task.setProjectOfTask(actualProject);
            task.setCreatedAt(new Date());
            taskService.createTask(task);
            return "redirect:/projects/{projectId}/tasks";
        }
    }

}
