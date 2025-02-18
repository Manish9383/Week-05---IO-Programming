package com.bridgelabz.advance_problems.encrypt_and_decrypt_csv_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeCSVReader {
    private static final String CSV_FILE_PATH = "src/main/resources/employees_encrypted.csv"; // Encrypted CSV filee

    public static void readAndDecryptCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line = reader.readLine();
            System.out.println(line);

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                String department = columns[2].trim();
                String decryptedSalary = AESEncryption.decrypt(columns[3].trim());
                String decryptedEmail = AESEncryption.decrypt(columns[4].trim());

                System.out.println(id + "," + name + "," + department + "," + decryptedSalary + "," + decryptedEmail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
