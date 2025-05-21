package org.lecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HotelFileReader {
    public List<Employee> readStaffFromCsv(String filePath) {
        //new ArrayList
        List<Employee> staff = new ArrayList<>();

        //BufferedReader method to read from the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            //supporting variable
            String line;
            //iterating through the file
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                //need to split because -> one value as one element in the Array
                String[] values = line.split(",");
                // check if all fields are filled
                if (values.length < 5) {
                    System.out.println("All information should be given in fields: " + line);
                    continue;
                }

                //read all elements and put in buffer with legal data type
                int employeeID = Integer.parseInt(values[0]);
                String name = values[1];
                HotelDepartment department = HotelDepartment.fromString(values[2]);
                HotelShift shift = HotelShift.fromString(values[3]);
                int reservationsNumberFirstWeek = Integer.parseInt(values[4]);
                int reservationsNumberSecondWeek = Integer.parseInt(values[5]);
                int reservationsNumberThirdWeek = Integer.parseInt(values[6]);

                //add the line to the ArrayList
                staff.add(new Employee(name, employeeID, department, shift, reservationsNumberFirstWeek,
                        reservationsNumberSecondWeek, reservationsNumberThirdWeek));
            }

        } catch (IOException e) {
            System.out.println("Error by reading the file: " + e.getMessage());
        }
        return staff;
    }
}
