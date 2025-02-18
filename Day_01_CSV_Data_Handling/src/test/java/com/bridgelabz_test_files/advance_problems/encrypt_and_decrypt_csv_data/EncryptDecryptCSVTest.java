package com.bridgelabz_test_files.advance_problems.encrypt_and_decrypt_csv_data;


import com.bridgelabz.advance_problems.encrypt_and_decrypt_csv_data.AESEncryption;
import com.bridgelabz.advance_problems.encrypt_and_decrypt_csv_data.EmployeeCSVReader;
import com.bridgelabz.advance_problems.encrypt_and_decrypt_csv_data.EmployeeCSVWriter;

import com.bridgelabz.advance_problems.encrypt_and_decrypt_csv_data.Main;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptDecryptCSVTest {

    @BeforeAll
    static void setUp() {
        AESEncryption.encrypt("test");
    }

    @Test
    void testAESEncryption() {
        String originalText = "Hello, World!";
        String encryptedText = AESEncryption.encrypt(originalText);
        assertNotNull(encryptedText, "Encryption should not return null");

        String decryptedText = AESEncryption.decrypt(encryptedText);
        assertNotNull(decryptedText, "Decryption should not return null");

        assertEquals(originalText, decryptedText, "Decrypted text should match the original text");
    }

    @Test
    void testEmployeeCSVReader() {
        EmployeeCSVReader.readAndDecryptCSV();

    }

    // Test EmployeeCSVWriter
    @Test
    void testEmployeeCSVWriter() {
        String jsonResponse = "[{\"id\":1,\"name\":\"Leanne Graham\",\"email\":\"Sincere@april.biz\"}," +
                "{\"id\":2,\"name\":\"Ervin Howell\",\"email\":\"Shanna@melissa.tv\"}]";

        EmployeeCSVWriter.writeEmployeeDataToCSV(jsonResponse);

    }

    @Test
    void testMain() {
        Main.main(new String[]{});
    }
}