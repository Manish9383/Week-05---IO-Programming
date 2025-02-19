package com.bridgelabz.ipl_and_censor_analyzer;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JsonProcessor {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<IplMatch> readJson(String filePath) throws Exception {
        return Arrays.asList(objectMapper.readValue(new File(filePath), IplMatch[].class));
    }

    public static void writeJson(String filePath, List<IplMatch> matches) throws Exception {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
    }
}
