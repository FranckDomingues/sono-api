package com.apisono.version1.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.apisono.version1.model.CsvFileDownload;

public class CSVHelper {

    public static ByteArrayInputStream CsvFileDownload(List<CsvFileDownload> csvFileDownloads) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (CsvFileDownload CsvFileDownload : csvFileDownloads) {
                List<String> data = Arrays.asList(
                        String.valueOf(CsvFileDownload.getId()),
                        CsvFileDownload.getTitle(),
                        CsvFileDownload.getDescription(),
                        String.valueOf(CsvFileDownload.isPublished())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
