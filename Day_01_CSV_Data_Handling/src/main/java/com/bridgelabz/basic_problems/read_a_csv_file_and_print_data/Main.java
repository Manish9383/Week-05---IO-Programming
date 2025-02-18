package com.bridgelabz.basic_problems.read_a_csv_file_and_print_data;


public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/StudentDetails.csv";
        StudentDetails student = new StudentDetails(filePath);
        student.details();
    }
}
