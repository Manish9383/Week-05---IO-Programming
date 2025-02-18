package com.bridgelabz.intermediate_problems.filter_records_from_csv;

import java.io.*;

public class CSVFilter {
    private String filePath;

    public CSVFilter(String filePath) {
        this.filePath = filePath;
    }

    public void filterHighScorers() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            System.out.println(line);

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[2].trim());

                if (marks > 80) {
                    System.out.println(line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
