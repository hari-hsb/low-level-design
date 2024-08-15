package com.example.LLDPractice.complete.ParkingLot.commands.impl;


import com.example.LLDPractice.complete.ParkingLot.commands.Command;

public class CreateParkingLotCommand extends Command {

    public CreateParkingLotCommand(String command) {
        super(command);
    }

    @Override
     public void execute() {
        String[] arr=getCommand().split(" ");
        this.getParkingLotController().createParkingLot(arr[1],Integer.valueOf(arr[2]),Integer.valueOf(arr[3]));
    }
}
