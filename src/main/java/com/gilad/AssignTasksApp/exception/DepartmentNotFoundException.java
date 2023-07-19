package com.gilad.AssignTasksApp.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
