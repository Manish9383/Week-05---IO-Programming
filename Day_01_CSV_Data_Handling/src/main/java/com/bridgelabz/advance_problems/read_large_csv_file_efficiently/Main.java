package com.bridgelabz.advance_problems.read_large_csv_file_efficiently;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/large_data.csv";
        int chunkSize = 100;
        LargeCSVReader.readCSVInChunks(filePath, chunkSize);
    }
}
