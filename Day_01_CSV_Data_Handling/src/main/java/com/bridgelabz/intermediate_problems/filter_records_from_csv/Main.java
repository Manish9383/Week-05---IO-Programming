package com.bridgelabz.intermediate_problems.filter_records_from_csv;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/StudentMarks.csv";
        CSVFilter filter = new CSVFilter(filePath);
        filter.filterHighScorers();
    }
}
