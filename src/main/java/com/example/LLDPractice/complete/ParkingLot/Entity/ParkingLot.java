package com.example.LLDPractice.complete.ParkingLot.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Getter
@Setter
public class ParkingLot {
    List<Floor> floorList=new ArrayList<>();
    String id;

    public void parkVehicle(Vehicle vehicle){
        for(Floor floor: floorList){
            if(floor.isparkingAvailable(vehicle.getVehicleype())){
                ParkingSpot parkingSpot=floor.bookParkingSpot(vehicle);
                System.out.println("Parked vehicle. Ticket ID:"+ id+"_"+floor.getId()+"_"+parkingSpot.getId());
                return;
            }
        }
        System.out.println("Parking Lot Full");

    }

    public void unParkVehicle(int floorId,int spotId){
        if(floorId>floorList.size()){
            System.out.println("Invalid Ticket");
            return;
        }

        Floor floor=floorList.get(floorId-1);
        if(spotId>floor.parkingSpotList.size()){
            System.out.println("Invalid Ticket");
            return;
        }
        floor.unparkFromParkingSpot(spotId-1);
    }
    public void printFreeSlotCount(VehicleType vehicleType){
        for(Floor floor: floorList){
            System.out.println("No. of free slots for "+vehicleType.toString()+" on Floor "+floor.getId()+" : "+floor.getTotalFreeSlot(vehicleType));
        }
    }
    public void printFreeSlotNumbers(VehicleType vehicleType){
        for(Floor floor: floorList){
            TreeSet<ParkingSpot> freeSpaceList=floor.getAllFreeSlots(vehicleType);
            StringBuilder b=new StringBuilder();
            for(ParkingSpot i:freeSpaceList){
                b.append(i.id+" ,");
            }
            System.out.println("Free slots for "+vehicleType.toString()+" on Floor "+floor.getId()+" :"+b.toString());
        }
    }

    public void printOccupiedSlotNumbers(VehicleType vehicleType){
        for(Floor floor: floorList){
            TreeSet<ParkingSpot> freeSpaceList=floor.getAllOccupiedSlots(vehicleType);
            StringBuilder b=new StringBuilder();
            for(ParkingSpot parkingSpot:freeSpaceList){
                b.append(parkingSpot.id+" ,");
            }
            System.out.println("Occupied slots for "+vehicleType.toString()+" on Floor "+floor.getId()+" :"+b.toString());
        }
    }
    void addFloor(int carSlot,int bikeSlot,int truckSlot){
        int id=floorList.size();
        Floor floor=new Floor(id+1);
        for(int i=0;i<truckSlot;i++){
            floor.addParkingSpot(VehicleType.TRUCK);
        }
        for(int i=0;i<bikeSlot;i++){
            floor.addParkingSpot(VehicleType.BIKE);
        }
        for(int i=0;i<carSlot;i++){
            floor.addParkingSpot(VehicleType.CAR);
        }
        floorList.add(floor);
    }





}
