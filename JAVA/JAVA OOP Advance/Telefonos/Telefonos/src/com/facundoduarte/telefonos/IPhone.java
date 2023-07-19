package com.facundoduarte.telefonos;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "Iphone " + super.getVersionNumber() + " dice " + super.getRingTone();
    }
    @Override
    public String unlock() {
        return "Desbloqueando desde reconocimiento facil";
    }
    @Override
    public void displayInfo() {
        System.out.println("Iphone " + super.getVersionNumber() + 
        " desde " + super.getCarrier());
    }
}


