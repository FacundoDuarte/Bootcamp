package com.facundoduarte.mvc.mvc.util;

import org.springframework.stereotype.Component;

@Component
public class LicenseNumberGenerator {
    private int licenseCounter = 0;

    public synchronized String generateLicenseNumber() {
        licenseCounter++;
        return String.format("%06d", licenseCounter);
    }
}
