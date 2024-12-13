package com.example.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(CategoryRepository categoryRepository, TaskRepository taskRepository) {
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Task> getTasksByUser(String username) {
        return taskRepository.findByUserUsername(username);
    }

    public void addTask(String username, Task task, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        task.setCategory(category);
        taskRepository.save(task);
    }
}
