package com.bridgelabz.hands_on_practice_problems.convert_csv_data_into_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {

    public static void main(String[] args) {
        String csvFile = "src/main/resources/data.csv";
        List<Map<String, String>> data = readCsv(csvFile);

        if (data.isEmpty()) {
            System.out.println("CSV file is empty or could not be read.");
            return;
        }

        String json = convertToJson(data);
        System.out.println(json);
    }

    public static List<Map<String, String>> readCsv(String filePath) {
        List<Map<String, String>> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String[] headers = br.readLine().split(","); // Read header row
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> dataMap = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    dataMap.put(headers[i].trim(), values[i].trim());
                }
                dataList.add(dataMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static String convertToJson(List<Map<String, String>> data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(data);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
