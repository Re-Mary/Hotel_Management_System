package org.lecture;

public enum HotelShift {
    MORNING,
    AFTERNOON,
    NIGHT;

    public static HotelShift fromString(String shift) {
        try {
            return HotelShift.valueOf(shift.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; //invalid shift
        }
    }
}
