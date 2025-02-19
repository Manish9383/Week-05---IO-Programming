package com.bridgelabz.practice_problems.parse_json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class JsonFilterExample {

    public static void jsonFiltering(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Person> people = objectMapper.readValue(jsonString, new TypeReference<List<Person>>() {});

        List<Person> filteredPeople = people.stream()
                .filter(p -> p.age > 25)
                .collect(Collectors.toList());

        String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredPeople);

        System.out.println(filteredJson);
    }
    public static void main(String[] args) throws JsonProcessingException {
        String jsonString = "[{\"name\":\"John\",\"age\":22},"
                + "{\"name\":\"Alice\",\"age\":30},"
                + "{\"name\":\"Bob\",\"age\":27},"
                + "{\"name\":\"Eve\",\"age\":24}]";

        jsonFiltering(jsonString);
    }
}
