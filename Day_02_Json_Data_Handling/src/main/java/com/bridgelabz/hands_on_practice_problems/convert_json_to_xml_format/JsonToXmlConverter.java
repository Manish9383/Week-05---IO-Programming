package com.bridgelabz.hands_on_practice_problems.convert_json_to_xml_format;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.Map;

public class JsonToXmlConverter {
    public static String convertJsonToXml(String json) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        Map<String, Object> map = jsonMapper.readValue(json, Map.class);

        return xmlMapper.writeValueAsString(map);
    }

    public static void main(String[] args) {
        String json = "{ \"employee\": { \"name\": \"John\", \"age\": 30, \"city\": \"New York\" } }";

        try {
            String xml = convertJsonToXml(json);
            System.out.println("XML Output:");
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
