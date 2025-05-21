package org.lecture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeWithAllReservations {
    private Employee employee;
    private List<Integer> allReservations;

    public EmployeeWithAllReservations(Employee employee) {
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }
}
