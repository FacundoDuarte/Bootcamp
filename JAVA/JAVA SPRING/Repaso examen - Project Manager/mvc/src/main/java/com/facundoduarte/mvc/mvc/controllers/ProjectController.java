package com.facundoduarte.mvc.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.facundoduarte.mvc.mvc.models.Project;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.services.ProjectService;
import com.facundoduarte.mvc.mvc.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            Long id = (Long) session.getAttribute("userId");
            User actualUser = userService.findUserById(id);
            List<Project> projectsLeader = projectService.allProjectsByLeader(id);
            model.addAttribute("projects_leader", projectsLeader);
            List<Project> projectsToJoin = projectService.allProjectsNotLeader(id);
            model.addAttribute("projects_join", projectsToJoin);
            model.addAttribute("user", actualUser);
            return "dashboard";
        }
    }

    @GetMapping(value = "/projects/new")
    public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            return "newProject";
        }
    }

    @RequestMapping(value = "/projects/new", method = RequestMethod.POST)
    public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result,
            HttpSession session, Model model) {
        if (result.hasErrors()) {
            return "newProject";
        } else {
            Long id = (Long) session.getAttribute("userId");
            User actualUser = userService.findUserById(id);
            project.setLeader(actualUser);
            projectService.createProject(project);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping(value = "/project/{projectId}/join", method = RequestMethod.POST)
    public String joinTeam(@PathVariable("projectId") Long projectId, HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("userId");
        User actualUser = userService.findUserById(id);
        Project actualProject = projectService.findProjectById(projectId);
        projectService.joinProject(actualProject, actualUser);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/project/{projectId}/leave", method = RequestMethod.POST)
    public String leaveTeam(@PathVariable("projectId") Long projectId, HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("userId");
        User actualUser = userService.findUserById(id);
        Project actualProject = projectService.findProjectById(projectId);
        projectService.leaveProject(actualProject, actualUser);
        return "redirect:/dashboard";
    }

    @GetMapping(value = "/projects/{projectId}/edit")
    public String editProject(@PathVariable("projectId") Long id,
            HttpSession session, Model model) {
        Project actualProject = projectService.findProjectById(id);
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else if (!session.getAttribute("userId").equals(actualProject.getLeader().getId())) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("project", actualProject);
            return "editProject";
        }
    }

    @RequestMapping(value = "/projects/{projectId}/edit", method = RequestMethod.POST)
    public String updateProject(@PathVariable("projectId") Long id, @Valid @ModelAttribute("project") Project project,
            BindingResult result,
            HttpSession session, Model model) {
        if (result.hasErrors()) {
            return "newProject";
        } else {
            Project actualProject = projectService.findProjectById(id);
            projectService.updateProject(actualProject, project);
            return "redirect:/dashboard";
        }
    }

    @GetMapping(value = "/project/{projectId}")
    public String showProject(@PathVariable("projectId") Long id,
            HttpSession session, Model model) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            Project actualProject = projectService.findProjectById(id);
            model.addAttribute("project", actualProject);
            return "showProject";
        }
    }

}
