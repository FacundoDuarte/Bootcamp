package com.facundoduarte.mvc.mvc.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Debes ingresar un titulo")
    private String title;
    @Size(min = 3, message = "La descripcion debe ser de al menos 3 caracteres")
    private String description;
    @NotNull(message = "Debes ingresar una fecha")
    @Future(message = "Solo se pueden fechas a futuro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishDate;

    @Transient
    private boolean joinedTeam = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User leader;

    @ManyToMany
    @JoinTable(name = "teammates", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> teammates;

    @OneToMany(mappedBy = "projectOfTask", fetch = FetchType.LAZY)
    private List<Task> tasksOfProject;

    public Project() {
    }

    public Project(String title,
            String description,
            LocalDate finishDate) {
        this.title = title;
        this.description = description;
        this.finishDate = finishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public List<User> getTeammates() {
        return teammates;
    }

    public void setTeammates(List<User> teammates) {
        this.teammates = teammates;
    }

    public boolean isJoinedTeam() {
        return joinedTeam;
    }

    public void setJoinedTeam(boolean joinedTeam) {
        this.joinedTeam = joinedTeam;
    }

    public boolean isJoinedByUser(User user) {
        for (User teammate : teammates) {
            if (teammate.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public List<Task> getTasksOfProject() {
        return tasksOfProject;
    }

    public void setTasksOfProject(List<Task> tasksOfProject) {
        this.tasksOfProject = tasksOfProject;
    }

}
