package com.bridgelabz.basic_problems.read_a_csv_file_and_print_data;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;

public class StudentDetails {
    private String filePath;

    public StudentDetails(String filePath)
    {
        this.filePath=filePath;
    }
    public void details()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



