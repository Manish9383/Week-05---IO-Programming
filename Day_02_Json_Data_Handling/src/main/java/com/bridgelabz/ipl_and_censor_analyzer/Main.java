package com.bridgelabz.ipl_and_censor_analyzer;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            List<IplMatch> jsonMatches = JsonProcessor.readJson("src/main/resources/ipl_censored.json");
            CensorshipRules.applyCensorship(jsonMatches);
            JsonProcessor.writeJson("src/main/resources/ipl_censoredGenerated.json", jsonMatches);
            System.out.println(" JSON processing complete! Censored file saved as 'ipl_censored.json'");


            List<IplMatch> csvMatches = CsvProcessor.readCsv("src/main/resources/ipl_data.csv");
            CensorshipRules.applyCensorship(csvMatches);
            CsvProcessor.writeCsv("src/main/resources/ipl_censoredGenerated.csv", csvMatches);
            System.out.println(" CSV processing complete! Censored file saved as 'ipl_censored.csv'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
