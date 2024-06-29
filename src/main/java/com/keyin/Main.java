package com.keyin;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create user");
            System.out.println("2. Add task");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Mark task as not completed");
            System.out.println("5. Remove task");
            System.out.println("6. View tasks (All)");
            System.out.println("7. View all users");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after nextInt()

            switch (choice) {
                // Create User
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    if (findUserByName(name) == null) {
                        users.add(new User(name));
                        System.out.println("User '" + name + "' created.");
                    } else {
                        System.out.println("User name already exists.");
                    }
                    seeMenu();
                    break;

                // Add Task
                case 2:
                    System.out.print("Enter user name: ");
                    name = scanner.nextLine();
                    User user = findUserByName(name);
                    if (user != null) {
                        System.out.print("Enter task title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        user.addTask(title, description);
                        System.out.println("Task added for user '" + name + "'.");
                    } else {
                        System.out.println("User not found.");
                    }
                    seeMenu();
                    break;

                // Mark Task as Completed
                case 3:
                    System.out.print("Enter user name: ");
                    name = scanner.nextLine();
                    user = findUserByName(name);
                    if (user != null) {
                        System.out.print("Enter task title to mark as completed: ");
                        String title = scanner.nextLine();
                        user.markTaskAsCompleted(title);
                        System.out.println("Task '" + title + "' marked as completed for user '" + name + "'.");
                    } else {
                        System.out.println("User not found.");
                    }
                    seeMenu();
                    break;

                // Mark Task as Not Completed
                case 4:
                    System.out.print("Enter user name: ");
                    name = scanner.nextLine();
                    user = findUserByName(name);
                    if (user != null) {
                        System.out.print("Enter task title to mark as not completed: ");
                        String title = scanner.nextLine();
                        user.markTaskAsUncompleted(title);
                        System.out.println("Task '" + title + "' marked as not completed for user '" + name + "'.");
                    } else {
                        System.out.println("User not found.");
                    }
                    seeMenu();
                    break;

                // Remove Task
                case 5:
                    System.out.print("Enter user name: ");
                    String nameToRemoveTask = scanner.nextLine();
                    User userToRemoveTask = findUserByName(nameToRemoveTask);
                    if (userToRemoveTask != null) {
                        System.out.print("Enter task title to remove: ");
                        String taskTitleToRemove = scanner.nextLine();
                        userToRemoveTask.removeTask(taskTitleToRemove);
                        System.out.println("Task '" + taskTitleToRemove + "' removed for user '" + nameToRemoveTask + "'.");
                    } else {
                        System.out.println("User not found.");
                    }
                    seeMenu();
                    break;

                // View Tasks (All)
                case 6:
                    System.out.print("Enter user name: ");
                    name = scanner.nextLine();
                    user = findUserByName(name);
                    if (user != null) {
                        System.out.println("All Tasks for user '" + name + "':");
                        user.printAllTasks();
                    } else {
                        System.out.println("User not found.");
                    }
                    seeMenu();
                    break;

                // View All Users
                case 7:
                    viewAllUsers();
                    seeMenu();
                    break;

                // Exit
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    seeMenu();
            }
        }
    }

    private static User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    private static void viewAllUsers() {
        System.out.println("All Users:");
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    private static void seeMenu() {
        System.out.println("\nPress Enter to see the menu again...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
