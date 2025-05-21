package org.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private List<Employee> staff;

    // constructor
    public HotelManager(List<Employee> staff) {
        this.staff = staff;
    }

    public void changeReservations(int employeeId, HotelShift shift, int reservations1, int reservations2, int reservations3) {
        for (Employee employee : staff) {
            if (employee.getEmployeeID() == employeeId && employee.getShift() == shift) {
                employee.setReservationsNumberFirstWeek(reservations1);
                employee.setReservationsNumberSecondWeek(reservations2);
                employee.setReservationsNumberThirdWeek(reservations3);
            }
        }
    }

    // Show all staff and departments (without number of reservations)
    public void showStaffAndDepartments() {
        List<Employee> uniqueEmployee = new ArrayList<>();

        for (Employee employee : staff) {

            boolean found = false;

            for(Employee row : uniqueEmployee) {
                if (row.getEmployeeID() == employee.getEmployeeID()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueEmployee.add(employee);
            }
        }

        for(Employee row : uniqueEmployee) {
            System.out.println("Name: " + row.getName() + ". Department: " + row.getDepartment());
        }
    }

    public void averageOfReservationPerEmployee() {
        List<EmployeeWithAllReservations> rows = new ArrayList<>();

        for (Employee employee : staff) {

            EmployeeWithAllReservations existingRow = null;

            for(EmployeeWithAllReservations row : rows) {
                if (row.getEmployee().getEmployeeID() == employee.getEmployeeID()) {
                    existingRow = row;
                    break;
                }
            }

            if (existingRow != null) {
                existingRow.addReservation(employee.getReservationsNumberFirstWeek());
                existingRow.addReservation(employee.getReservationsNumberSecondWeek());
                existingRow.addReservation(employee.getReservationsNumberThirdWeek());
            } else {
                var newRow = new EmployeeWithAllReservations(employee);
                newRow.addReservation(employee.getReservationsNumberFirstWeek());
                newRow.addReservation(employee.getReservationsNumberSecondWeek());
                newRow.addReservation(employee.getReservationsNumberThirdWeek());
                rows.add(newRow);
            }
        }

        for(EmployeeWithAllReservations row : rows) {
            System.out.println("Name: " + row.getEmployee().getName() + ". Average of reservations: " + row.calculateAverage());
        }
    }

    public void averageOfReservationPerDepartment() {
        List<DepartmentWithAllReservations> rows = new ArrayList<>();

        for (Employee employee : staff) {

            DepartmentWithAllReservations existingRow = null;

            for(DepartmentWithAllReservations row : rows) {
                if (row.getDepartment() == employee.getDepartment()) {
                    existingRow = row;
                    break;
                }
            }

            if (existingRow != null) {
                existingRow.addReservation(employee.getReservationsNumberFirstWeek());
                existingRow.addReservation(employee.getReservationsNumberSecondWeek());
                existingRow.addReservation(employee.getReservationsNumberThirdWeek());
            } else {
                var newRow = new DepartmentWithAllReservations(employee.getDepartment());
                newRow.addReservation(employee.getReservationsNumberFirstWeek());
                newRow.addReservation(employee.getReservationsNumberSecondWeek());
                newRow.addReservation(employee.getReservationsNumberThirdWeek());
                rows.add(newRow);
            }
        }

        for(DepartmentWithAllReservations row : rows) {
            System.out.println("Department: " + row.getDepartment() + ". Average of reservations: " + row.calculateAverage());
        }
    }

    public void averageOfReservationPerShift() {
        List<ShiftWithAllReservations> rows = new ArrayList<>();

        for (Employee employee : staff) {

            ShiftWithAllReservations existingRow = null;

            for(ShiftWithAllReservations row : rows) {
                if (row.getHotelShift() == employee.getShift()) {
                    existingRow = row;
                    break;
                }
            }

            if (existingRow != null) {
                existingRow.addReservation(employee.getReservationsNumberFirstWeek());
                existingRow.addReservation(employee.getReservationsNumberSecondWeek());
                existingRow.addReservation(employee.getReservationsNumberThirdWeek());
            } else {
                var newRow = new ShiftWithAllReservations(employee.getShift());
                newRow.addReservation(employee.getReservationsNumberFirstWeek());
                newRow.addReservation(employee.getReservationsNumberSecondWeek());
                newRow.addReservation(employee.getReservationsNumberThirdWeek());
                rows.add(newRow);
            }
        }

        for(ShiftWithAllReservations row : rows) {
            System.out.println("Shift: " + row.getHotelShift() + ". Average of reservations: " + row.calculateAverage());
        }
    }

    public void writeReportToFile() {
        List<EmployeeWithReservationsPerShift> rows = new ArrayList<>();

        for (Employee employee : staff) {

            EmployeeWithReservationsPerShift existingRow = null;

            for(EmployeeWithReservationsPerShift row : rows) {
                if (row.getEmployee().getEmployeeID() == employee.getEmployeeID()) {
                    existingRow = row;
                    break;
                }
            }

            if (existingRow != null) {
                existingRow.addReservation(employee.getShift(), employee.getReservationsNumberFirstWeek());
                existingRow.addReservation(employee.getShift(), employee.getReservationsNumberSecondWeek());
                existingRow.addReservation(employee.getShift(), employee.getReservationsNumberThirdWeek());
            } else {
                var newRow = new EmployeeWithReservationsPerShift(employee);
                newRow.addReservation(employee.getShift(), employee.getReservationsNumberFirstWeek());
                newRow.addReservation(employee.getShift(), employee.getReservationsNumberSecondWeek());
                newRow.addReservation(employee.getShift(), employee.getReservationsNumberThirdWeek());
                rows.add(newRow);
            }
        }

        List<String> reportLines = new ArrayList<>();
        for(EmployeeWithReservationsPerShift row : rows) {
            reportLines.add("Employee: " + row.getEmployee().getName());
            reportLines.add("Department: " + row.getEmployee().getDepartment());
            reportLines.add("Shift: Morning");
            reportLines.add("Average Reservations:" + String.format("%.2f", row.calculateAverage(HotelShift.MORNING)));
            reportLines.add("Shift: Afternoon");
            reportLines.add("Average Reservations:" + String.format("%.2f", row.calculateAverage(HotelShift.AFTERNOON)));
            reportLines.add("Shift: Night");
            reportLines.add("Average Reservations:" + String.format("%.2f", row.calculateAverage(HotelShift.NIGHT)));
            reportLines.add("");
        }

        Path pathUpdatedFile = Paths.get("src", "main", "resources", "example_examHotel_report.txt");
        HotelFileWriter writer = new HotelFileWriter();
        writer.writeEmployeeReport(pathUpdatedFile.toString(), reportLines);
    }

    public void writeUserQuery(Integer employeeID, HotelShift shift) {
        EmployeeWithReservationsPerShift report = null;

        for (Employee employee : staff) {
            if (employee.getEmployeeID() != employeeID) {
                continue;
            }

            if (report != null) {
                report.addReservation(employee.getShift(), employee.getReservationsNumberFirstWeek());
                report.addReservation(employee.getShift(), employee.getReservationsNumberSecondWeek());
                report.addReservation(employee.getShift(), employee.getReservationsNumberThirdWeek());
            } else {
                report = new EmployeeWithReservationsPerShift(employee);
                report.addReservation(employee.getShift(), employee.getReservationsNumberFirstWeek());
                report.addReservation(employee.getShift(), employee.getReservationsNumberSecondWeek());
                report.addReservation(employee.getShift(), employee.getReservationsNumberThirdWeek());
            }
        }

        System.out.println("Name: " + report.getEmployee().getName() + ", Shift: " + shift + ". Average of reservations: " + String.format("%.2f",report.calculateAverage(shift))
                + " Total reservations: " + report.calculateSum(shift));
    }
}
