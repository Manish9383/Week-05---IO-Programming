package com.bridgelabz.basic_problems.read_and_count_rows_in_a_csv_file;

import java.io.*;

public class CountRows {
    private String filePath;

    public CountRows(String filePath) {
        this.filePath = filePath;
    }

    public int countRecords() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}

