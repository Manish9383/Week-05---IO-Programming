package com.bridgelabz.advance_problems.generate_a_csv_report_from_database;
public class Main {
    public static void main(String[] args) {
        // Fetch employee data from API
        String jsonResponse = EmployeeAPIClient.fetchEmployeeData();

        // Process and write to CSV
        EmployeeCSVWriter.writeEmployeeDataToCSV(jsonResponse);
    }
}
