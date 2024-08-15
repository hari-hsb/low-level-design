package com.example.LLDPractice.complete.ParkingLot.Entity;

import com.example.LLDPractice.complete.ParkingLot.ParkingSpotManager.BikeParkingManager;
import com.example.LLDPractice.complete.ParkingLot.ParkingSpotManager.CarParkingManager;
import com.example.LLDPractice.complete.ParkingLot.ParkingSpotManager.ParkingSpotManager;
import com.example.LLDPractice.complete.ParkingLot.ParkingSpotManager.TruckParkingManager;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Getter
@Setter
public class Floor {
    int id;
    List<ParkingSpot> parkingSpotList=new ArrayList<>();
    CarParkingManager carParkingManager=new CarParkingManager();
    TruckParkingManager truckParkingManager=new TruckParkingManager();
    BikeParkingManager bikeParkingManager=new BikeParkingManager();

    public Floor(int id) {
        this.id = id;
    }

    ParkingSpotManager getParkingSpotManager(VehicleType vehicleType){
        switch (vehicleType){
            case TRUCK:
                return this.truckParkingManager;
            case BIKE:
                return this.bikeParkingManager;
            case CAR:
                return this.carParkingManager;
            default:
                throw new RuntimeException();
        }
    }

    public void addParkingSpot(VehicleType vehicleType){
        int id=this.parkingSpotList.size()+1;
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(vehicleType);
        ParkingSpot parkingSpot=new ParkingSpot();
        parkingSpot.setVehicleType(vehicleType);
        parkingSpot.setId(id);
        parkingSpot.setBooked(false);
        parkingSpotManager.addParkingSpot(parkingSpot);
        this.parkingSpotList.add(parkingSpot);
    }


    public ParkingSpot bookParkingSpot(Vehicle vehicle){
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(vehicle.getVehicleype());
        return parkingSpotManager.bookParkingSpot(vehicle);
    }
    public void unparkFromParkingSpot(int id){
        ParkingSpot parkingSpot=this.parkingSpotList.get(id);
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(parkingSpot.getVehicleType());
        parkingSpotManager.unparkFromParkingSpot(parkingSpot);
    }

    int getTotalOccupiedSlot(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(vehicleType);
        return parkingSpotManager.getNumberOfOccupiedSlot();
    }

    int getTotalFreeSlot(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(vehicleType);
        return parkingSpotManager.getNumberOfFreeSlot();
    }
    public boolean isparkingAvailable(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(vehicleType);
       return parkingSpotManager.isParkingAvailble();
    }
    public TreeSet<ParkingSpot> getAllFreeSlots(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(vehicleType);
        return parkingSpotManager.getAllUnParkedSpotId();
    }

    public TreeSet<ParkingSpot> getAllOccupiedSlots(VehicleType vehicleType){
        ParkingSpotManager parkingSpotManager=getParkingSpotManager(vehicleType);
        return parkingSpotManager.getAllOccupiedSpotId();
    }




}
