package com.bridgelabz.advance_problems.convert_json_to_csv_and_vice_versa;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Starting conversions...");

        JsonToCsvConverter.convertJsonToCsv();

        CsvToJsonConverter.convertCsvToJson();

        System.out.println(" Conversions completed!");
    }
}
