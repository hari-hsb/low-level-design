package com.example.LLDPractice.complete.ParkingLot.Entity;

public class ParkingLotController {
    ParkingLot parkingLot;
    static ParkingLotController instance = null;

    public static ParkingLotController getInstance() {
        if (instance == null) {
            synchronized (ParkingLotController.class) {
                if (instance == null) {
                    instance = new ParkingLotController();
                }
            }
        }
        return instance;
    }

    private ParkingLotController() {
    }


    public void createParkingLot(String id, int floor, int slot) {
        int truckSlot = 1;
        int bikes = 2;
        int car = slot - truckSlot - bikes;
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(id);
        for (int i = 0; i < floor; i++) {
            parkingLot.addFloor(car, bikes, truckSlot);
        }
        this.parkingLot = parkingLot;
        System.out.println();
    }

    public void printOccupiedSlotNumbers(String s) {
        parkingLot.printOccupiedSlotNumbers(VehicleType.valueOf(s));
    }

    public void printFreeSlotNumbers(String s) {
        parkingLot.printFreeSlotNumbers(VehicleType.valueOf(s));
    }

    public void printFreeSlotCount(String s) {
        parkingLot.printFreeSlotCount(VehicleType.valueOf(s));
    }

    public void unParkVehicle(int floorId,int spotId) {
        parkingLot.unParkVehicle(floorId,spotId);
    }

    public void parkVehicle(Vehicle vehicle) {
        parkingLot.parkVehicle(vehicle);
    }
}