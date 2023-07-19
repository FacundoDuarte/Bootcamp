package com.facundoduarte.telefonos;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "Galaxy " + super.getVersionNumber() + " dice " + super.getRingTone();
    }
    @Override
    public String unlock() {
        return "Desbloqueando via huella digital";
    }
    @Override
    public void displayInfo() {
        System.out.println("Galaxy " + super.getVersionNumber() + 
        " desde " + super.getCarrier());
    }
}


