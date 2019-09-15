package com.company.configuration;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://skvop6yiqbgj7mzc:i7e9fdjxeqtbmxlt@uf63wl4z2daq9dbb.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/is2vccet4iamaoay";
    private static final String USERNAME = "skvop6yiqbgj7mzc";
    private static final String PASSWORD = "i7e9fdjxeqtbmxlt";

    private Connection connection;

    public String getHeadOfDepartment(String departmentName) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select first_name, last_name from lectors where id=(select head_of_department from departments" +
                    " where department_name = '" + departmentName + "')");
            while (resultSet.next()) {
                return "Head of " + departmentName + " department is " + resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Cannot find " + departmentName + " department";
        }
        return "Cannot find " + departmentName + " department";
    }

    public String getDepartmentStatistic(String departmentName) {
        int[] temp = new int[3];
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select degree from lectors where department_id = (select department_id from departments" +
                    " where department_name = '" + departmentName + "')");
            while (resultSet.next()) {
                switch (resultSet.getString("degree")) {
                    case "assistant":
                        ++temp[0];
                        break;
                    case "associate professor":
                        ++temp[1];
                        break;
                    case "professor":
                        ++temp[2];
                        break;
                }
            }
            return "assistants - " + temp[0] + ". \n" +
                    "  associate professors - " + temp[1] + "\n" +
                    "  professors - " + temp[2] + "\n";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Cannot find " + departmentName + " department";
        }
    }

    public String getAverageSalary(String departmentName) {
        int avgSal = 0;
        int counter = 0;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select salary from lectors where department_id=(select department_id from departments" +
                    " where department_name = '" + departmentName + "')");
            while (resultSet.next()) {
                avgSal = resultSet.getInt("salary");
                counter++;
            }
            return "Average salary of " + departmentName + " department is " + avgSal / counter;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Cannot find " + departmentName + " department";
        }
    }

    public String getEmployeeCount(String departmentName) {
        int counter = 0;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from lectors where department_id = (select department_id from departments" +
                    " where department_name = '" + departmentName + "')");
            while (resultSet.next()) {
                counter++;
            }
            return "" + counter;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Cannot find " + departmentName + " department";
        }
    }

    public String globalSearch(String template) {
        String result = "";
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select first_name, last_name from lectors");
            while (resultSet.next()) {
                if (resultSet.getString("first_name").contains(template) || resultSet.getString("last_name").contains(template)) {
                    result += resultSet.getString("first_name") + " " + resultSet.getString("last_name") + ", ";
                }
            }
            result = result.substring(0, result.length() - 2);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Unexpected error";
    }
}
