package com.example.LLDPractice.complete.ParkingLot.commands.impl;

import com.example.LLDPractice.complete.ParkingLot.commands.Command;

public class FreeCountCommand extends Command {
    public FreeCountCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        String[] arr=getCommand().split(" ");
        this.getParkingLotController().printFreeSlotCount(arr[2]);
    }
}
