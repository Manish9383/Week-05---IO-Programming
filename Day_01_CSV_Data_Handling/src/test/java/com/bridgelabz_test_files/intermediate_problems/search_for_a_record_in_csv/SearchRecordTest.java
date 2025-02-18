package com.bridgelabz_test_files.intermediate_problems.search_for_a_record_in_csv;


import com.bridgelabz.intermediate_problems.search_for_a_record_in_csv.SearchRecord;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class SearchRecordTest {

    private static final String TEST_CSV_FILE = "src/test/resources/employee_test.csv";

    @BeforeEach
    void setUp() throws IOException {
        String sampleCsvData = """
            ID, Name, Department, Salary
            1, Manish Patel, IT, 50000
            2, Alice, HR, 60000
            3, Bob, Finance, 70000
            """;
        Files.write(Paths.get(TEST_CSV_FILE), sampleCsvData.getBytes());
    }

    @Test
    @DisplayName("Test Search for Employee by Name")
    void testSearchByName() {
        String target = "Manish Patel";
        String[] employee = SearchRecord.searchByName(TEST_CSV_FILE, target);

        assertNotNull(employee, "Employee record should not be null.");
        assertEquals("Manish Patel", employee[1].trim(), "Employee name should match the target name.");
        assertEquals("IT", employee[2].trim(), "Employee department should match.");
        assertEquals("50000", employee[3].trim(), "Employee salary should match.");
    }

    @Test
    @DisplayName("Test Search for Employee with Non-Existing Name")
    void testSearchByNameNotFound() {
        String target = "John Doe";
        String[] employee = SearchRecord.searchByName(TEST_CSV_FILE, target);

        assertNull(employee, "Employee record should be null if the name is not found.");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}
