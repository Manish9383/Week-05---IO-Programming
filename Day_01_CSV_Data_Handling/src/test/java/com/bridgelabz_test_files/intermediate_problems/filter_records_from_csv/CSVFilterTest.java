package com.bridgelabz_test_files.intermediate_problems.filter_records_from_csv;

import com.bridgelabz.intermediate_problems.filter_records_from_csv.CSVFilter;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class CSVFilterTest {

    private static final String TEST_CSV_FILE = "src/test/resources/StudentMarks_test.csv";

    @BeforeEach
    void setUp() throws IOException {
        // Create a sample test CSV file with student marks
        String sampleCsvData = """
            ID, Name, Marks
            1, Manish Patel, 87
            2, Bob, 70
            3, David, 65
            4, Sankalp Dwivedi, 93
            """;
        Files.write(Paths.get(TEST_CSV_FILE), sampleCsvData.getBytes());
    }

    @Test
    @DisplayName("Test Filtering High Scorers (Marks > 80)")
    void testFilterHighScorers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CSVFilter filter = new CSVFilter(TEST_CSV_FILE);
        filter.filterHighScorers();

        System.setOut(System.out);

        String expectedOutput = """
        ID, Name, Marks
        1, Manish Patel, 87
        4, Sankalp Dwivedi, 93
        """;

        String actualOutput = outputStream.toString().trim().replaceAll("\\s+", " ");
        String normalizedExpectedOutput = expectedOutput.trim().replaceAll("\\s+", " ");

        assertEquals(normalizedExpectedOutput, actualOutput, "Output should match high scorers.");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}
