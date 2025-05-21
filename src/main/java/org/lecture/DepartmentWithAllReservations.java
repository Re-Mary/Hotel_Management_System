package org.lecture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DepartmentWithAllReservations {
    private HotelDepartment department;
    private List<Integer> allReservations;

    public DepartmentWithAllReservations(HotelDepartment department) {
        this.department = department;
        this.allReservations = new ArrayList<>();
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

    public HotelDepartment getDepartment() {
        return department;
    }
}
