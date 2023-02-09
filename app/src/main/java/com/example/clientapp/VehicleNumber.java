package com.example.clientapp;

import java.util.ArrayList;

public class VehicleNumber {
    int id;
    String Number;

    static ArrayList<VehicleNumber> vehicleNumbers=new ArrayList<>();

    public VehicleNumber(int id, String number) {
        this.id = id;
        Number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public static void initVehicleNumbers(){
        vehicleNumbers.add(new VehicleNumber(1,"GJ34H3425"));
        vehicleNumbers.add(new VehicleNumber(2,"BA93PA1948"));
        vehicleNumbers.add(new VehicleNumber(3,"MH34H3425"));
        vehicleNumbers.add(new VehicleNumber(4,"BR34H3425"));
    }

    public static ArrayList<VehicleNumber> getVehicleNumbers() {
        return vehicleNumbers;
    }
}
