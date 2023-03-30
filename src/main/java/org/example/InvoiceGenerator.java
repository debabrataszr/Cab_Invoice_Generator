package org.example;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_COST_PER_KM = 10;
    private static final double MINIMUM_FARE = 5;
    Map<String, Ride[]> userRides = new HashMap<>();

    public InvoiceSummary getInvoiceSummary(String userID) {
        Ride[] rides = userRides.get(userID);
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;

        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userID, Ride[] rides) {
        userRides.put(userID, rides);
    }
}