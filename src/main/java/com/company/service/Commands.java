package com.company.service;

public enum Commands {
    HELP("/help"),
    HEAD_OF_DEPARTMENT("Who is the head of department"),
    AVERAGE_SALARY_FOR_DEPARTMENT("Show the average salary for department"),
    DEPARTMENT_EMPLOYEE_COUNT("Show count of employees for"),
    SEARCH("Global search by");

    private String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}