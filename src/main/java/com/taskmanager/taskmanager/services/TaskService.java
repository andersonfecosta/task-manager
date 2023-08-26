package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.entities.Task;
import com.taskmanager.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public Task updateTask(Long id, Task taskUpdated) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task!=null) {
            task.setTitle(taskUpdated.getTitle());
            task.setDescription(taskUpdated.getDescription());
            task.setDueDate(taskUpdated.getDueDate());
            task.setAssignees(taskUpdated.getAssignees());
            task.setInvitations(taskUpdated.getInvitations());
            task.setStatus(taskUpdated.getStatus());
            return taskRepository.save(task);
        }
        return null;
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
