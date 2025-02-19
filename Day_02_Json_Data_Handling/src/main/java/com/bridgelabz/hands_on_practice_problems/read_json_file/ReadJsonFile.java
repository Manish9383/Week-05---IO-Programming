package com.bridgelabz.hands_on_practice_problems.read_json_file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/read_json_data.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(file);

            printJson(rootNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                System.out.println(prefix + entry.getKey() + ": ");
                printJson(entry.getValue(), prefix + "  ");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                System.out.println(prefix + "[" + i + "]: ");
                printJson(node.get(i), prefix + "  ");
            }
        } else {
            System.out.println(prefix + node.asText());
        }
    }
}
