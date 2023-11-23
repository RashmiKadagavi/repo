package com.example.techtestspring.util;


import com.example.techtestspring.modal.NaceDetails;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class NaceHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Order", "Level","Code","Parent","Description","This item includes","This item also includes","Rulings","This item excludes","Reference to ISIC Rev. 4"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<NaceDetails> csvToNaceDetails(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<NaceDetails> naceDetailsList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                NaceDetails naceDetails = new NaceDetails(
                        Long.parseLong(csvRecord.get("Order")),
                        csvRecord.get("Level"),
                        csvRecord.get("Code"),
                        csvRecord.get("Parent"),
                        csvRecord.get("Description"),
                        csvRecord.get("This item includes"),
                        csvRecord.get("This item also includes"),
                        csvRecord.get("Rulings"),
                        csvRecord.get("This item excludes"),
                        csvRecord.get("Reference to ISIC Rev. 4")

                );

                naceDetailsList.add(naceDetails);
            }

            return naceDetailsList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
}
}
