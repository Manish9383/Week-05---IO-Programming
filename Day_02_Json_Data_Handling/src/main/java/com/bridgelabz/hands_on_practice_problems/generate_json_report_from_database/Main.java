package com.bridgelabz.hands_on_practice_problems.generate_json_report_from_database;


public class Main {
    public static void main(String[] args) {
        String jsonResponse = EmployeeAPIClient.fetchEmployeeData();

        EmployeeJSONReportGenerator.generateReport(jsonResponse);
    }
}
