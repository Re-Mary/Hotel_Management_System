package org.lecture;

public class Employee {
    private String name;
    private int employeeID;
    private HotelDepartment department;
    private HotelShift shift;
    private int reservationsNumberFirstWeek;
    private int reservationsNumberSecondWeek;
    private int reservationsNumberThirdWeek;


    //constructor
    public Employee(String name, int EmployeeID, HotelDepartment department, HotelShift shift, int reservationsNumberFirstWeek,
                    int reservationsNumberSecondWeek, int reservationsNumberThirdWeek) {
        this.name = name;
        this.employeeID = EmployeeID;
        this.department = department;
        this.shift = shift;
        this.reservationsNumberFirstWeek = reservationsNumberFirstWeek;
        this.reservationsNumberSecondWeek = reservationsNumberSecondWeek;
        this.reservationsNumberThirdWeek = reservationsNumberThirdWeek;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public HotelDepartment getDepartment() {
        return department;
    }

    public void setDepartment(HotelDepartment department) {
        this.department = department;
    }

    public HotelShift getShift() {
        return shift;
    }

    public void setShift(HotelShift shift) {
        this.shift = shift;
    }

    public int getReservationsNumberFirstWeek() {
        return reservationsNumberFirstWeek;
    }
    public void setReservationsNumberFirstWeek(int value) {
        this.reservationsNumberFirstWeek = value;
    }

    public int getReservationsNumberSecondWeek() {
        return reservationsNumberSecondWeek;
    }
    public void setReservationsNumberSecondWeek(int value) {
        this.reservationsNumberSecondWeek = value;
    }

    public int getReservationsNumberThirdWeek() {
        return reservationsNumberThirdWeek;
    }
    public void setReservationsNumberThirdWeek(int value) {
        this.reservationsNumberThirdWeek = value;
    }

    @Override
    public String toString() {
        return name + "," + employeeID + "," + department + "," + shift + ","
                + reservationsNumberFirstWeek + "," + reservationsNumberSecondWeek + "," + reservationsNumberThirdWeek;
    }
}
