package com.example.LLDPractice.complete.ParkingLot.commands;

import com.example.LLDPractice.complete.ParkingLot.Entity.ParkingLotController;
import lombok.Getter;

@Getter
public abstract class Command {
    String command;
    ParkingLotController parkingLotController;

    public Command(String command) {
        this.command = command;
        this.parkingLotController=ParkingLotController.getInstance();
    }

    public abstract void execute();
}
