package com.example.adapters.out.filesystem;

import com.example.ports.out.StockReportOutPort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

public class CSVPersistence implements StockReportOutPort {

    public static final String PATH_FILE = "exports/";

    @Override
    public void saveReport(Map<String, String> report) {
        final String csv = this.convertToCSV(report);
        String filename = this.getTimedFileName("stock_report.csv");
        try {
            createDirectory();
            Files.write(Paths.get(PATH_FILE + filename), csv.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDirectory() {
        File directory = new File(PATH_FILE);
        if (! directory.exists()){
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
    }

    private String convertToCSV(Map<String, String> report) {
        StringBuilder stringBuilder = new StringBuilder();
        String header = String.join(";", report.keySet());
        String row = String.join(";", report.values());
        stringBuilder.append(header);
        stringBuilder.append("\n");
        stringBuilder.append(row);

        return stringBuilder.toString();
    }

    private String getTimedFileName(String fileName){
        LocalDateTime now = LocalDateTime.now();
        String[] fileParts = fileName.split("\\.");

        String currentTime = String.format("%d_%d_%d_%d_%d_%d",
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(), // date
                now.getHour(), now.getMinute(), now.getSecond()); // time

        return fileParts[0] + "_" + currentTime + "." + fileParts[1];
    }
}
