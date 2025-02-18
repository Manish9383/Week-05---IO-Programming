package com.bridgelabz_test_files.basic_problems.read_a_csv_file_and_print_data;


import com.bridgelabz.basic_problems.read_a_csv_file_and_print_data.StudentDetails;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class StudentDetailsTest {

    private static final String TEST_CSV_FILE = "src/main/resources/StudentDetails.csv";

    @BeforeEach
    void setUp() throws IOException {
        // Create a sample test CSV file
        String sampleCsvData = """
            1,Alice
            2,Bob
            3,Charlie
            """;
        Files.write(Paths.get(TEST_CSV_FILE), sampleCsvData.getBytes());
    }

    @Test
    @DisplayName("Test if StudentDetails reads and prints data correctly")
    void testDetails() {
        // Redirect system output to capture printed content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentDetails studentDetails = new StudentDetails(TEST_CSV_FILE);
        studentDetails.details();

        // Restore system output
        System.setOut(System.out);

        // Expected Output
        String expectedOutput = """
            ID: 1, Name: Alice
            ID: 2, Name: Bob
            ID: 3, Name: Charlie
            """;

        assertEquals(expectedOutput.trim(), outputStream.toString().trim(), "Output should match expected student details.");
    }

    @AfterEach
    void tearDown() throws IOException {
        // Delete the test CSV file after execution
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}
