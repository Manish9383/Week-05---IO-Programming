package com.bridgelabz.advance_problems.encrypt_and_decrypt_csv_data;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class EmployeeCSVWriter {
    private static final String CSV_FILE_PATH = "src/main/resources/employees_encrypted.csv";
    private static final String[] DEPARTMENTS = {"HR", "Finance", "IT", "Sales", "Marketing", "Operations"};
    private static final Random RANDOM = new Random();

    public static void writeEmployeeDataToCSV(String jsonResponse) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            JSONArray employees = new JSONArray(jsonResponse);


            writer.write("Employee ID, Name, Department, Decrypted Salary, Decrypted Email\n");


            for (int i = 0; i < employees.length(); i++) {
                JSONObject emp = employees.getJSONObject(i);

                int id = emp.getInt("id");
                String name = emp.getString("name");
                String department = DEPARTMENTS[RANDOM.nextInt(DEPARTMENTS.length)];
                int salary = 50000 + RANDOM.nextInt(50000);
                String email = emp.getString("email");

                // Encrypt Salary and Email
                String encryptedSalary = AESEncryption.encrypt(String.valueOf(salary));
                String encryptedEmail = AESEncryption.encrypt(email);


                writer.write(id + "," + name + "," + department + "," + encryptedSalary + "," + encryptedEmail + "\n");
            }

            System.out.println(" Encrypted CSV file generated successfully: " + CSV_FILE_PATH);

        } catch (IOException | org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
