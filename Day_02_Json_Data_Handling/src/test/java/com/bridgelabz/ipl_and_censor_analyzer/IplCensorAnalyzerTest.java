package com.bridgelabz.ipl_and_censor_analyzer;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IplCensorAnalyzerTest {

    private List<IplMatch> testMatches;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @TempDir
    Path tempDir;  // Temporary directory for test files

    private File tempJsonFile;
    private File tempCsvFile;

    @BeforeEach
    void setUp() {
        testMatches = Arrays.asList(
                new IplMatch(101, "Mumbai Indians", "Chennai Super Kings", 178, 182, "Chennai Super Kings", "MS Dhoni"),
                new IplMatch(102, "Royal Challengers Bangalore", "Delhi Capitals", 200, 190, "Royal Challengers Bangalore", "Virat Kohli")
        );

        // ✅ Corrected temp file paths
        tempJsonFile = tempDir.resolve("test_ipl.json").toFile();
        tempCsvFile = tempDir.resolve("test_data.csv").toFile();
    }

    @Test
    void testJsonProcessing() throws Exception {
        // ✅ Write JSON file
        JsonProcessor.writeJson(tempJsonFile.getAbsolutePath(), testMatches);

        // ✅ Read back JSON file
        List<IplMatch> readMatches = JsonProcessor.readJson(tempJsonFile.getAbsolutePath());

        // ✅ Assertions
        assertEquals(2, readMatches.size());
        assertEquals("Mumbai Indians", readMatches.get(0).getTeam1());
        assertEquals("MS Dhoni", readMatches.get(0).getPlayer_of_match());
    }

    @Test
    void testCsvProcessing() throws Exception {
        // ✅ Write CSV file
        CsvProcessor.writeCsv(tempCsvFile.getAbsolutePath(), testMatches);

        // ✅ Read back CSV file
        List<IplMatch> readMatches = CsvProcessor.readCsv(tempCsvFile.getAbsolutePath());

        // ✅ Assertions
        assertEquals(2, readMatches.size());
        assertEquals("Delhi Capitals", readMatches.get(1).getTeam2());
        assertEquals("Virat Kohli", readMatches.get(1).getPlayer_of_match());
    }

    @Test
    void testCensorshipRules() {
        CensorshipRules.applyCensorship(testMatches);

        // ✅ Assertions for censorship rules
        assertEquals("Mumbai ***", testMatches.get(0).getTeam1());
        assertEquals("Chennai ***", testMatches.get(0).getWinner());
        assertEquals("REDACTED", testMatches.get(0).getPlayer_of_match());

        assertEquals("Royal ***", testMatches.get(1).getTeam1());
        assertEquals("Delhi ***", testMatches.get(1).getTeam2());
        assertEquals("REDACTED", testMatches.get(1).getPlayer_of_match());
    }

    @AfterEach
    void cleanUp() throws Exception {
        // ✅ Ensure test files are deleted after each test
        Files.deleteIfExists(tempJsonFile.toPath());
        Files.deleteIfExists(tempCsvFile.toPath());
    }
}
