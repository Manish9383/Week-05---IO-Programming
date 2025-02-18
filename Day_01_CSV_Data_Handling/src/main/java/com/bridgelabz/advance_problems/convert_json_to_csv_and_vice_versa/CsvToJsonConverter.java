package com.bridgelabz.advance_problems.convert_json_to_csv_and_vice_versa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvToJsonConverter {
    private static final String CSV_FILE = "src/main/resources/studentsMainFile.csv";
    private static final String JSON_OUTPUT_FILE = "src/main/resources/students_output.json";

    public static void convertCsvToJson() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            List<Student> students = new ArrayList<>();
            List<String[]> lines = reader.readAll();


            for (int i = 1; i < lines.size(); i++) {
                String[] data = lines.get(i);
                students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]
                ));
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(JSON_OUTPUT_FILE), students);
            System.out.println(" CSV to JSON conversion completed. Saved to: " + JSON_OUTPUT_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
