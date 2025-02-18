package com.bridgelabz.advance_problems.convert_json_to_csv_and_vice_versa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class JsonToCsvConverter {
    private static final String JSON_FILE = "src/main/resources/studentsMainFile.json";
    private static final String CSV_FILE = "src/main/resources/students_output.csv";

    public static void convertJsonToCsv() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = objectMapper.readValue(new File(JSON_FILE), new TypeReference<List<Student>>() {});

            try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
                // Write header
                writer.writeNext(new String[]{"ID", "Name", "Age", "Grade"});

                // Write student data
                for (Student student : students) {
                    writer.writeNext(new String[]{
                            String.valueOf(student.getId()),
                            student.getName(),
                            String.valueOf(student.getAge()),
                            student.getGrade()
                    });
                }
            }

            System.out.println(" JSON to CSV conversion completed. Saved to: " + CSV_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
