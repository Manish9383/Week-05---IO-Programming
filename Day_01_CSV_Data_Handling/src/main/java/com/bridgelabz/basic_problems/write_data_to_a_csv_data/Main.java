package com.bridgelabz.basic_problems.write_data_to_a_csv_data;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employee.csv";
        EmployeeDetails writer = new EmployeeDetails(filePath);
        writer.writeCSV();
    }
}
