package com.example.LLDPractice.complete.ParkingLot.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
    VehicleType vehicleType;
    Integer id;
    boolean isBooked;
    Vehicle vehicle;
}
