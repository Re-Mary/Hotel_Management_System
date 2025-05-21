package org.lecture;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HotelFileWriter {
    public void writeEmployeeReport(String filePath, List<String> reportLines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String reportLine : reportLines) {
                bw.write(reportLine);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error by file writing: " + e.getMessage());
        }
    }
}
