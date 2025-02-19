package com.bridgelabz.hands_on_practice_problems.validate_an_email;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class EmailValidation {
    public static void main(String[] args) {
        String schemaJson = "{"
                + "\"$schema\": \"http://json-schema.org/draft-07/schema#\","
                + "\"type\": \"object\","
                + "\"properties\": {"
                + "\"email\": {"
                + "\"type\": \"string\","
                + "\"format\": \"email\""
                + "}"
                + "},"
                + "\"required\": [\"email\"]"
                + "}";

        String jsonInput = "{ \"email\": \"test@example.com\" }";

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode schemaNode = objectMapper.readTree(schemaJson);
            JsonNode jsonData = objectMapper.readTree(jsonInput);

            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema jsonSchema = schemaFactory.getJsonSchema(schemaNode);

            ProcessingReport report = jsonSchema.validate(jsonData);

            if (report.isSuccess()) {
                System.out.println("Valid email!");
            } else {
                System.out.println("Invalid email: " + report);
            }
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
