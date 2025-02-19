package com.bridgelabz.ipl_and_censor_analyzer;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvProcessor {

    public static List<IplMatch> readCsv(String filePath) throws Exception {
        try (Reader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8)) {
            CsvToBean<IplMatch> csvToBean = new CsvToBeanBuilder<IplMatch>(reader)
                    .withType(IplMatch.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            return csvToBean.parse();
        }
    }

    public static void writeCsv(String filePath, List<IplMatch> matches) throws Exception {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
            StatefulBeanToCsv<IplMatch> beanToCsv = new StatefulBeanToCsvBuilder<IplMatch>(writer)
                    .withApplyQuotesToAll(false)
                    .build();
            beanToCsv.write(matches);
        }
    }
}
