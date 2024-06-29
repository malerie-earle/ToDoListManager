package com.keyin;

public class TaskList {
    private TaskNode head;

    private static class TaskNode {
        private Task task;
        private TaskNode next;

        public TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public TaskList() {
        this.head = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markTaskAsCompleted(String title) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markAsCompleted();
                break;
            }
            current = current.next;
        }
    }

    public void markTaskAsUncompleted(String title) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markAsUncompleted();
                break;
            }
            current = current.next;
        }
    }

    public void removeTask(String title) {
        if (head == null) {
            return;
        }
        if (head.task.getTitle().equals(title)) {
            head = head.next;
            return;
        }
        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.getTitle().equals(title)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void printTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
