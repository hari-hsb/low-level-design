package com.example.LLDPractice.complete.ParkingLot.commands;


import com.example.LLDPractice.complete.ParkingLot.commands.impl.*;

public class CommandFactory {
    public static Command getCommand(String s){
        Command command;
        String[] arr=s.split(" ");
        switch (arr[0]){
            case "create_parking_lot":
                return new CreateParkingLotCommand(s);
            case "display":{
                switch (arr[1]){
                    case "free_count":
                        return new FreeCountCommand(s);
                    case "free_slots":
                        return new FreeSlotsCommand(s);
                    case "occupied_slots":
                        return new OccupiedSlotsCommand(s);
                }
            }
            case "park_vehicle":
                return new ParkVehicleCommand(s);
            case "unpark_vehicle":
                return new UnParkvehicleCommand(s);
            case"exit":
                return new ExitCommand(s);
            default:
        }
        return null;
    }

}
