package com.example.LLDPractice.complete.ParkingLot.commands.impl;

import com.example.LLDPractice.complete.ParkingLot.commands.Command;

public class OccupiedSlotsCommand extends Command {
    public OccupiedSlotsCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        String[] arr=getCommand().split(" ");
        this.getParkingLotController().printOccupiedSlotNumbers(arr[2]);
    }
}
