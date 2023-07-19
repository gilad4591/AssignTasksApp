package com.gilad.AssignTasksApp.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
