package com.bridgelabz.practice_problems.merge_two_json_objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonMergeExample {

    public static void mergingTwoJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String json1 = "{ \"name\": \"Alice\", \"age\": 25 }";
        String json2 = "{ \"city\": \"New York\", \"age\": 30 }"; // Overlapping key "age"

        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        ObjectNode mergedNode = (ObjectNode) node1.deepCopy();
        mergedNode.setAll((ObjectNode) node2);

        String mergedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);

        System.out.println("Merged JSON: " + mergedJson);

    }
    public static void main(String[] args) throws Exception {
       mergingTwoJson();
    }
}
