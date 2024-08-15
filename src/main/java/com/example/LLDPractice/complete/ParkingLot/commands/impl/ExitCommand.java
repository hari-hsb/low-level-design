package com.example.LLDPractice.complete.ParkingLot.commands.impl;

import com.example.LLDPractice.complete.ParkingLot.commands.Command;

public class ExitCommand extends Command {
    public ExitCommand(String command) {
        super(command);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
