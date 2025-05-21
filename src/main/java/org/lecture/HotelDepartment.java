package org.lecture;

public enum HotelDepartment {
    HOUSEKEEPING,
    RECEPTION,
    ADMINISTRATION;

    public static HotelDepartment fromString(String department) {
        try {
            return HotelDepartment.valueOf(department.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; //invalid department
        }
    }
}
