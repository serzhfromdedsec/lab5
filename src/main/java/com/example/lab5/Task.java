package com.example.lab5;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Task() {}

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
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title.trim();
    }

    public String getDescription() {
        return description != null ? description : "No description available.";
    }

    public void setDescription(String description) {
        this.description = description != null ? description.trim() : null;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        if (user == null) {
            throw new IllegalStateException("User cannot be null.");
        }
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void assignToUser(UserEntity user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot assign task to null user");
        }
        this.user = user;
    }

    public void assignToCategory(Category category) {
        this.category = category;
    }
}