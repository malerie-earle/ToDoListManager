package com.keyin;

public class User {
    private String name;
    private TaskList tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new TaskList();
    }

    public void addTask(String title, String description) {
        Task newTask = new Task(title, description);
        tasks.addTask(newTask);
        System.out.println("Task added: " + newTask);
    }

    public void markTaskAsCompleted(String title) {
        tasks.markTaskAsCompleted(title);
    }

    public void markTaskAsUncompleted(String title) {
        tasks.markTaskAsUncompleted(title);
    }

    public void removeTask(String title) {
        tasks.removeTask(title);
    }

    public void printAllTasks() {
        tasks.printTasks();
    }

    public String getName() {
        return name;
    }
}
