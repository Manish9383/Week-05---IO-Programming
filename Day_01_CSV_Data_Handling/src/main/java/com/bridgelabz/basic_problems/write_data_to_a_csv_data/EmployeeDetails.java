package com.bridgelabz.basic_problems.write_data_to_a_csv_data;
import java.io.*;

public class EmployeeDetails {
    private String filePath;

    public EmployeeDetails(String filePath) {
        this.filePath = filePath;
    }

    public void writeCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,JOb Role,Salary\n");
            writer.write("101,Manish Patel,Manager,122000\n");
            writer.write("102,Raj Chandanan,Cloud Solutions Expert,62000\n");
            writer.write("103,Om Tamrakar,Senior Software Developer,44000\n");
            writer.write("104,Akash Dhakad,Full Stack Developer,60000\n");
            writer.write("105,Arpita Goutam,Data Analyst,70000\n");
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
