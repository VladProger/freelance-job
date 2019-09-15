package com.company.service;

import com.company.configuration.DBConnection;

public class TextHandleService {
    private static final DBConnection dbConnection = new DBConnection();

    public String messageManager(String userText) {

        if (userText.startsWith((Commands.HEAD_OF_DEPARTMENT.getCommand()))) {
            userText = stringRebuild(userText, Commands.HEAD_OF_DEPARTMENT.getCommand().length());
            return dbConnection.getHeadOfDepartment(userText);

        } else if (userText.startsWith("Show ") && userText.endsWith("statistics")) {
            int cutEnd = 10;//statistics = 10 letters
            int cutBegin = 5;//Show+space = 5 letters
            userText = userText.substring(cutBegin);
            userText = userText.substring(0, userText.length() - cutEnd).trim();
            return dbConnection.getDepartmentStatistic(userText);

        } else if (userText.startsWith(Commands.AVERAGE_SALARY_FOR_DEPARTMENT.getCommand())) {
            userText = stringRebuild(userText, Commands.AVERAGE_SALARY_FOR_DEPARTMENT.getCommand().length());
            return dbConnection.getAverageSalary(userText);

        } else if (userText.startsWith(Commands.DEPARTMENT_EMPLOYEE_COUNT.getCommand())) {
            userText = stringRebuild(userText, Commands.DEPARTMENT_EMPLOYEE_COUNT.getCommand().length());
            return dbConnection.getEmployeeCount(userText);

        } else if (userText.startsWith(Commands.SEARCH.getCommand())) {
            userText = stringRebuild(userText, Commands.SEARCH.getCommand().length());
            return dbConnection.globalSearch(userText);

        } else if (userText.startsWith(Commands.HELP.getCommand()) || userText.equalsIgnoreCase("/start")) {
            return "Hi! Available commands:\nWho is the head of department {department_name}\nShow {department_name} statistics\n" +
                    "Show average salary for department {department_name}\nShow count of employees for {department_name}\nGlobal search by {template}" +
                    "\nI'm sorry if I'm slow, it is just because each message travels thousands of kilometers\nAnd please don't use dot (It makes me hurt)";
        }
        return "Unknown command";
    }

    String stringRebuild(String string, int length) {
        string = string.substring((length)).trim();
        return string;
    }
}
