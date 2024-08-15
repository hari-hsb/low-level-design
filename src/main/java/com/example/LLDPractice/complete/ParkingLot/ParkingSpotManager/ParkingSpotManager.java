package com.example.LLDPractice.complete.ParkingLot.ParkingSpotManager;

import com.example.LLDPractice.complete.ParkingLot.Entity.ParkingSpot;
import com.example.LLDPractice.complete.ParkingLot.Entity.Vehicle;

import java.util.*;

public abstract class ParkingSpotManager {
//    PriorityQueue<Integer> unOccupied=new PriorityQueue<>();
    TreeSet<ParkingSpot> occupied=new TreeSet<>(Comparator.comparingInt(ParkingSpot::getId));
    TreeSet<ParkingSpot> unOccupied=new TreeSet<>(Comparator.comparingInt(ParkingSpot::getId));


    public void addParkingSpot(ParkingSpot parkingSpot){
        unOccupied.add(parkingSpot);
    }

    public ParkingSpot bookParkingSpot(Vehicle vehicle){
        ParkingSpot parkingSpot= getNearestParkingSpot();
        unOccupied.remove(parkingSpot);
        parkingSpot.setVehicle(vehicle);
        parkingSpot.setBooked(true);
        occupied.add(parkingSpot);
        return parkingSpot;
    }
    public void unparkFromParkingSpot(ParkingSpot parkingSpot){
        if(!parkingSpot.isBooked()){
            System.out.println("Invalid Ticket");
            return;
        }
        Vehicle v=parkingSpot.getVehicle();
        parkingSpot.setBooked(false);
        parkingSpot.setVehicle(null);
        unOccupied.add(parkingSpot);
        occupied.remove(parkingSpot);
        System.out.println("Unparked vehicle with Registration Number: "+v.getRegNumber()+" and Color: "+v.getColor());
    }

    private ParkingSpot getNearestParkingSpot() {
        return unOccupied.first();
    }

    public int getNumberOfFreeSlot(){
        return unOccupied.size();
    }
    public int getNumberOfOccupiedSlot(){
        return occupied.size();
    }

    public boolean isParkingAvailble() {
        return !unOccupied.isEmpty();
    }

      public TreeSet<ParkingSpot> getAllUnParkedSpotId(){
        return unOccupied;
    }
    public TreeSet<ParkingSpot> getAllOccupiedSpotId(){
        return occupied;
    }
}
