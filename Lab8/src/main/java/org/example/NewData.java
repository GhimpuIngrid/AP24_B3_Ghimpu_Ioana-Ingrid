package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewData {
    String filePath = "C:\\Users\\Ingrid\\Downloads\\archive\\books.csv";

    public void readData() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(filePath));

        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        for(CSVRecord csvRecord : csvParser) {
            String title = csvRecord.get("Title");
            String author = csvRecord.get("Authors");
            String year = csvRecord.get("publication_date");

            System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year);
        }
    }
}
