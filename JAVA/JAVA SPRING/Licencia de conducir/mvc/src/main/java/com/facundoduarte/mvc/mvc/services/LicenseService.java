package com.facundoduarte.mvc.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.License;
import com.facundoduarte.mvc.mvc.repositories.LicenseRepository;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }

    public License createLicense(License l) {
        return licenseRepository.save(l);
    }

    public License findByPerson(Long id) {
        License license = licenseRepository.findByPersonId(id);
        return license;
    }
}
