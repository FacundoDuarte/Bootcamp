package com.facundoduarte.mvc.mvc.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Debes ingresar un nombre")
    private String firstName;
    @NotBlank(message = "Debes ingresar un apellido")
    private String lastName;
    @Email(message = "El correo es obligatorio")
    private String email;
    @Size(min = 5, message = "La contraseña debe tener 5 caracteres como minimo")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "leader", fetch = FetchType.LAZY)
    private List<Project> projectsCreated;

    @ManyToMany
    @JoinTable(name = "teammates", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projectsJoined;

    @OneToMany(mappedBy = "taskCreator", fetch = FetchType.LAZY)
    private List<Task> tasksCreated;

    public User() {
    }

    public User(String firstName,
            String lastName,
            String email,
            String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Project> getProjectsCreated() {
        return projectsCreated;
    }

    public void setProjectsCreated(List<Project> projectsCreated) {
        this.projectsCreated = projectsCreated;
    }

    public List<Project> getProjectsJoined() {
        return projectsJoined;
    }

    public void setProjectsJoined(List<Project> projectsJoined) {
        this.projectsJoined = projectsJoined;
    }

}
