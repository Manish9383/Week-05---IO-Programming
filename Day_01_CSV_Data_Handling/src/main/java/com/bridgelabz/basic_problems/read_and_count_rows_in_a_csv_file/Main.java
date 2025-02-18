package com.bridgelabz.basic_problems.read_and_count_rows_in_a_csv_file;


public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employee.csv";
        CountRows reader = new CountRows(filePath);
        int recordCount = reader.countRecords();
        System.out.println("Total records (excluding header): " + recordCount);
    }
}
