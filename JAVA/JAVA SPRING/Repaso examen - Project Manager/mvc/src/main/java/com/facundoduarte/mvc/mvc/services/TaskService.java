package com.facundoduarte.mvc.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Task;
import com.facundoduarte.mvc.mvc.repositories.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> tasksByProject(Long id) {
        return taskRepository.findByTaskByProjectId(id);
    }
}
