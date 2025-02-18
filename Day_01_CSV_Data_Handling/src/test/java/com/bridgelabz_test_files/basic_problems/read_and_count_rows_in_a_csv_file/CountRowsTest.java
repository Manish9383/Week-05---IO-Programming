package com.bridgelabz_test_files.basic_problems.read_and_count_rows_in_a_csv_file;


import com.bridgelabz.basic_problems.read_and_count_rows_in_a_csv_file.CountRows;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class CountRowsTest {

    private static final String TEST_CSV_FILE = "src/test/resources/employee_test.csv";

    @BeforeEach
    void setUp() throws IOException {

        String sampleCsvData = """
            ID,Name,JOb Role,Salary
            101,Manish Patel,Manager,122000
            102,Raj Chandanan,Cloud Solutions Expert,62000
            103,Om Tamrakar,Senior Software Developer,44000
            104,Akash Dhakad,Full Stack Developer,60000
            105,Arpita Goutam,Data Analyst,70000
            """;
        Files.write(Paths.get(TEST_CSV_FILE), sampleCsvData.getBytes());
    }

    @Test
    @DisplayName("Test Counting Records Excluding Header")
    void testCountRecords() {
        CountRows reader = new CountRows(TEST_CSV_FILE);
        int recordCount = reader.countRecords();


        assertEquals(5, recordCount, "Record count should match the number of rows excluding the header.");
    }

    @Test
    @DisplayName("Test Counting Records for Empty File")
    void testCountRecordsEmptyFile() throws IOException {
        Files.write(Paths.get(TEST_CSV_FILE), "".getBytes());

        CountRows reader = new CountRows(TEST_CSV_FILE);
        int recordCount = reader.countRecords();

        assertEquals(0, recordCount, "Record count should be 0 for an empty file.");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}
