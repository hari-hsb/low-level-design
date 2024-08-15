package com.example.LLDPractice.complete.ParkingLot.commands.impl;

import com.example.LLDPractice.complete.ParkingLot.commands.Command;

public class UnParkvehicleCommand extends Command {
    public UnParkvehicleCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        String[] arr=getCommand().split(" ");
        int floorId=Integer.valueOf(arr[1].split("_")[1]);
        int spotId=Integer.valueOf(arr[1].split("_")[2]);


//        unpark_vehicle PR1234_2_5
        getParkingLotController().unParkVehicle(floorId,spotId);



    }
}
