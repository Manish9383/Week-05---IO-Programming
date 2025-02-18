package com.bridgelabz.advance_problems.encrypt_and_decrypt_csv_data;

import com.bridgelabz.advance_problems.generate_a_csv_report_from_database.EmployeeAPIClient;

public class Main {
    public static void main(String[] args) {
        String jsonResponse = EmployeeAPIClient.fetchEmployeeData();

        // Encrypt & Write Data to CSV
        EmployeeCSVWriter.writeEmployeeDataToCSV(jsonResponse);

        // Read & Decrypt Data from CSV
        System.out.println("\n Decrypted Employee Data:");
        EmployeeCSVReader.readAndDecryptCSV();
    }
}
