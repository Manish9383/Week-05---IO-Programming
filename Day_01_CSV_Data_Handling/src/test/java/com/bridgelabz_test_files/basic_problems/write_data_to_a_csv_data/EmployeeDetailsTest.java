package com.bridgelabz_test_files.basic_problems.write_data_to_a_csv_data;


import com.bridgelabz.basic_problems.write_data_to_a_csv_data.EmployeeDetails;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDetailsTest {

    private static final String TEST_CSV_FILE = "src/test/resources/employee_test.csv";

    @BeforeEach
    void setUp() throws IOException {
        // Ensure the file is clean before writing
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }

    @Test
    @DisplayName("Test Writing Employee Data to CSV")
    void testWriteCSV() {
        EmployeeDetails writer = new EmployeeDetails(TEST_CSV_FILE);
        writer.writeCSV();

        File csvFile = new File(TEST_CSV_FILE);
        assertTrue(csvFile.exists(), "CSV file should be created.");

        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_CSV_FILE))) {
            String header = reader.readLine();
            assertEquals("ID,Name,JOb Role,Salary", header, "Header should match the expected CSV format.");

            String line1 = reader.readLine();
            assertEquals("101,Manish Patel,Manager,122000", line1, "First employee's data should match.");

            String line2 = reader.readLine();
            assertEquals("102,Raj Chandanan,Cloud Solutions Expert,62000", line2, "Second employee's data should match.");

            String line3 = reader.readLine();
            assertEquals("103,Om Tamrakar,Senior Software Developer,44000", line3, "Third employee's data should match.");

            String line4 = reader.readLine();
            assertEquals("104,Akash Dhakad,Full Stack Developer,60000", line4, "Fourth employee's data should match.");

            String line5 = reader.readLine();
            assertEquals("105,Arpita Goutam,Data Analyst,70000", line5, "Fifth employee's data should match.");
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred while reading the file.");
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_CSV_FILE));
    }
}
