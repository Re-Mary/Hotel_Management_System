package org.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeWithReservationsPerShift {
    private Employee employee;
    private HashMap<HotelShift, List<Integer>> shiftReservationsPairs;

    public EmployeeWithReservationsPerShift(Employee employee) {
        this.employee = employee;
        this.shiftReservationsPairs = new HashMap<>();
    }

    public void addReservation(HotelShift shift, int reservationsNumbers) {
        List<Integer> storedReservationsNumbers = shiftReservationsPairs.get(shift);
        if (storedReservationsNumbers == null) {
            storedReservationsNumbers = new ArrayList<>();
            storedReservationsNumbers.add(reservationsNumbers);
            shiftReservationsPairs.put(shift, storedReservationsNumbers);
        }
        else {
            storedReservationsNumbers.add(reservationsNumbers);
        }
    }

    public double calculateAverage(HotelShift shift) {
        List<Integer> storedReservationsNumbers = shiftReservationsPairs.get(shift);
        return (double) this.calculateSum(shift) / storedReservationsNumbers.size();
    }

    public int calculateSum(HotelShift shift) {
        List<Integer> storedReservationsNumbers = shiftReservationsPairs.get(shift);
        int sum = 0;
        for (int reservation : storedReservationsNumbers) {
            sum += reservation;
        }

        return sum;
    }

    public Employee getEmployee() {
        return employee;
    }
}
