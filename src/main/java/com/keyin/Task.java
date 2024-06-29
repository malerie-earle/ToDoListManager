package com.keyin;

public class Task {
    private String title;
    private String description;
    private boolean isCompleted;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public void markAsUncompleted() {
        isCompleted = false;
    }

    @Override
    public String toString() {
        return "Task - " + title +
                ", Description: " + description +
                ", isCompleted: " + isCompleted +
                '.';
    }
}
