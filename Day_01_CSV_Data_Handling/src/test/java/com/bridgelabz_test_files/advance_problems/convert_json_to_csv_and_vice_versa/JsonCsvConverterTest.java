package com.bridgelabz_test_files.advance_problems.convert_json_to_csv_and_vice_versa;

import com.bridgelabz.advance_problems.convert_json_to_csv_and_vice_versa.CsvToJsonConverter;
import com.bridgelabz.advance_problems.convert_json_to_csv_and_vice_versa.JsonToCsvConverter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

class JsonCsvConverterTest {

    private static final String JSON_FILE = "src/main/resources/students_output.json";
    private static final String CSV_FILE = "src/main/resources/students_output.csv";
    private static final String OUTPUT_JSON_FILE = "src/main/resources/students_output.json";

    @BeforeEach
    void setUp() throws Exception {

        String sampleJson = """
            [
                {"id": 1, "name": "Alice", "age": 20, "grade": "A"},
                {"id": 2, "name": "Bob", "age": 21, "grade": "B"}
            ]
            """;
        Files.write(Paths.get(JSON_FILE), sampleJson.getBytes());
    }

    @Test
    @DisplayName("Test JSON to CSV Conversion")
    void testJsonToCsv() {
        JsonToCsvConverter.convertJsonToCsv();
        File csvFile = new File(CSV_FILE);
        assertTrue(csvFile.exists(), "CSV file should be created.");
        assertTrue(csvFile.length() > 0, "CSV file should not be empty.");
    }

    @Test
    @DisplayName("Test CSV to JSON Conversion")
    void testCsvToJson() {
        JsonToCsvConverter.convertJsonToCsv();
        CsvToJsonConverter.convertCsvToJson();
        File jsonFile = new File(OUTPUT_JSON_FILE);
        assertTrue(jsonFile.exists(), "Output JSON file should be created.");
        assertTrue(jsonFile.length() > 0, "Output JSON file should not be empty.");
    }

    @AfterEach
    void tearDown() {
//         Clean up test files
        new File(JSON_FILE).delete();
        new File(CSV_FILE).delete();
        new File(OUTPUT_JSON_FILE).delete();
    }
}
