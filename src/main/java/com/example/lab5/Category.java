package com.example.lab5;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public List<Task> getTasks() {
        return List.copyOf(tasks);
    }

    public void setTasks(List<Task> tasks) {
        if (tasks != null) {
            this.tasks = new ArrayList<>(tasks);
        }
    }

    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
            task.setCategory(this);
        }
    }

    public void removeTask(Task task) {
        if (task != null) {
            tasks.remove(task);
            task.setCategory(null);
        }
    }
}