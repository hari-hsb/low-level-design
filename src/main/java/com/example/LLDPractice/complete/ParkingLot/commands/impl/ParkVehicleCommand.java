package com.example.LLDPractice.complete.ParkingLot.commands.impl;

import com.example.LLDPractice.complete.ParkingLot.Entity.Vehicle;
import com.example.LLDPractice.complete.ParkingLot.Entity.VehicleType;
import com.example.LLDPractice.complete.ParkingLot.commands.Command;

public class ParkVehicleCommand extends Command {
    public ParkVehicleCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        //TRUCK KA-32-SJ-5389 orange
        String[] arr=getCommand().split(" ");
        Vehicle vehicle=new Vehicle();
        vehicle.setColor(arr[3]);
        vehicle.setVehicleype(VehicleType.valueOf(arr[1]));
        vehicle.setRegNumber(arr[2]);
        this.getParkingLotController().parkVehicle(vehicle);
    }
}
