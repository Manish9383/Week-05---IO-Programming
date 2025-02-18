package com.bridgelabz.intermediate_problems.modify_a_csv_file;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/employee.csv";
        String targetDepartment="Data Analyst";
        ModifyRecords.increaseSalary(filePath,targetDepartment);
    }
}
