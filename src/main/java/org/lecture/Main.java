//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package org.lecture;

/*Prüfungsaufgabe: Hotelmanagement-System
Entwickle ein Java-Programm zur Verwaltung von Hotelreservierungen. Das Programm soll Daten aus einer
Datei namens hotel_management_data.csv einlesen und verschiedene Berichte generieren. Erstelle ein
passendes Menü.
*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //read the file
        //path to the file
        Path file = Paths.get("src", "main", "resources", "hotel_management_data.csv");
        //check if exist
        if (Files.notExists(file)) {
            System.err.println("File not found. " + file.toAbsolutePath());
        }
        //initialisation of file reader
        HotelFileReader reader = new HotelFileReader();
        List<Employee> staff = reader.readStaffFromCsv(file.toString());
        //initialisation of hotel manager
        HotelManager manager = new HotelManager(staff);

        // MENU
        Scanner input = new Scanner(System.in);
        String menu = """
                _______ MENU _______
                
                1 - Show all staff and departments (without number of reservations).
                2 - Average of reservation per employee.
                3 - Average of reservation per department.
                4 - Average of reservation per shift.
                5 - Save a report to file.
                6 - User query.
                7 - Change reservations.
                8 - ---.
                9 - Exit.
                """;

        // repeated menu
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menu);
            int userChoice;

            try {
                userChoice = input.nextInt(); // save user choice
                input.nextLine();             // clean up the buffer
            } catch (Exception e) {
                System.out.println("Input is not correct. Please put the number between 1 and 9");
                input.nextLine();
                continue;
            }

            switch (userChoice) {
                case 1 -> manager.showStaffAndDepartments();
                case 2 -> manager.averageOfReservationPerEmployee();
                case 3 -> manager.averageOfReservationPerDepartment();
                case 4 -> manager.averageOfReservationPerShift();
                case 5 -> manager.writeReportToFile();
                case 6 -> showUserMenu(input, manager);
                case 7 -> changeReservations(input, manager);
                case 9 -> {
                    isRunning = false;
                    System.out.println("Exiting...");
                }
                default -> throw new IllegalStateException("Unexpected value: " + userChoice);
            }


        }



// Menü: Anzeige
//        Zeige alle Mitarbeiter und ihre jeweilige Abteilung an (ohne die Reservierungszahlen).
//
// Menü: Durchschnittsberechnung
//        Berechne die durchschnittliche Anzahl der bearbeiteten Reservierungen pro Mitarbeiter, Abteilung und Schicht.
//
// Menü: Berichterstellung
//        Schreibe einen Bericht in eine Ausgabedatei im korrekten Projektordner
//        in example_exam/<nachname>/hotel_report.txt, der für jeden Mitarbeiter,
//        Abteilung und Schicht die durchschnittliche Anzahl der bearbeiteten Reservierungen anzeigt.
//        Runde den Durchschnitt auf zwei Nachkommastellen.
//        Beispiel eines Berichtauszugs:
//
//        Employee: Sophie Schaefer
//        Department: Housekeeping
//        Shift: Morning
//        Average Reservations: 11.33
//        Shift: Afternoon
//        Average Reservations: 8.67
//        Shift: Night
//        Average Reservations: 10
//
//        Employee: Max Wagner
//        Department: Reception
//        Shift: Morning
//        Average Reservations: 46
//        (etc.)
//
// Menü: Benutzerabfrage
//        Implementiere eine Methode, die es ermöglicht, die durchschnittliche und insgesamte Anzahl der bearbeiteten
//        Reservierungen für einen bestimmten Mitarbeiter (mittels ID) und einer auswählbaren Schicht abzufragen.

    }

    private static void changeReservations(Scanner input, HotelManager manager) {
        System.out.print("Enter employee ID: ");
        int employeeId = input.nextInt();
        input.nextLine();
        System.out.print("Enter shift: ");
        String shift = input.nextLine();
        System.out.print("Enter reservation first: ");
        int reservationFirst = input.nextInt();
        System.out.print("Enter reservation second: ");
        int reservationSecond = input.nextInt();
        System.out.print("Enter reservation third: ");
        int reservationThird = input.nextInt();

        manager.changeReservations(employeeId, HotelShift.fromString(shift), reservationFirst, reservationSecond, reservationThird);
    }

    private static void showUserMenu(Scanner input, HotelManager manager) {
        System.out.print("Enter employee ID: ");
        int employeeId = input.nextInt();
        input.nextLine();
        System.out.print("Enter shift: ");
        String shift = input.nextLine();
        manager.writeUserQuery(employeeId, HotelShift.fromString(shift));
    }
}