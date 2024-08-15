package com.example.LLDPractice.complete.ParkingLot.commands.impl;

import com.example.LLDPractice.complete.ParkingLot.commands.Command;

public class FreeSlotsCommand extends Command {
    public FreeSlotsCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        String[] arr=getCommand().split(" ");
        this.getParkingLotController().printFreeSlotNumbers(arr[2]);
    }
}
