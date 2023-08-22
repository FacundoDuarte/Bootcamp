package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Project;
import com.facundoduarte.mvc.mvc.models.User;
import com.facundoduarte.mvc.mvc.repositories.ProjectRepository;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project actualProject, Project project) {
        actualProject.setDescription(project.getDescription());
        actualProject.setTitle(project.getTitle());
        actualProject.setFinishDate(project.getFinishDate());
        return projectRepository.save(actualProject);
    }

    public Project leaveProject(Project project, User actualUser) {
        project.getTeammates().remove(actualUser);
        project.setJoinedTeam(false);
        return projectRepository.save(project);
    }

    public Project joinProject(Project project, User actualUser) {
        project.getTeammates().add(actualUser);
        project.setJoinedTeam(true);
        return projectRepository.save(project);
    }

    public Project findProjectById(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }

    public List<Project> allProjects(User currentUser) {
        List<Project> projects = projectRepository.findAll();
        for (Project project : projects) {
            project.setJoinedTeam(project.isJoinedByUser(currentUser));
        }
        return projects;
    }

    public List<Project> allProjectsByLeader(Long id) {
        return projectRepository.findByLeaderId(id);
    }

    public List<Project> allProjectsNotLeader(Long id) {
        return projectRepository.findProjectsWhereNotLeader(id);
    }
}
