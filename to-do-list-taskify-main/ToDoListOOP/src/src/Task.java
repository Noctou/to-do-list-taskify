package src;

import java.sql.Timestamp;

public class Task {
    private String title;
    private String description;
    private Timestamp deadline;
    private boolean completed;
    
    public Task(String title, String description, Timestamp deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.completed = false;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Timestamp getDeadline() { return deadline; }
    public boolean isCompleted() { return completed; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDeadline(Timestamp deadline) { this.deadline = deadline; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    // Toggle completion status
    public void toggleCompleted() {
        this.completed = !this.completed;
    }
}