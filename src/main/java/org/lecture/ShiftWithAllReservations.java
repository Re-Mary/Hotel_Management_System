package org.lecture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShiftWithAllReservations {
    private HotelShift hotelShift;
    private List<Integer> allReservations;

    public ShiftWithAllReservations(HotelShift hotelShift) {
        this.hotelShift = hotelShift;
        this.allReservations = new ArrayList<>();
    }

    public HotelShift getHotelShift() {
        return hotelShift;
    }

    public void addReservation(int reservationsNumbers) {
        allReservations.add(reservationsNumbers);
    }

    public BigDecimal calculateAverage() {
        Integer sum = 0;
        for (Integer reservation : allReservations) {
            sum += reservation;
        }

        return BigDecimal.valueOf(sum / allReservations.size());
    }
}
