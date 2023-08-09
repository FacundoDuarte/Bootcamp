package com.facundoduarte.mvc.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Country;
import com.facundoduarte.mvc.mvc.repositories.CountryRepository;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Object[]> getCountriesSpeakingSlovene() {
        return countryRepository.findCountriesSpeakingSlovene();
    }

    public List<Object[]> getTotalCitiesPerCountry() {
        return countryRepository.findTotalCitiesPerCountry();
    }

    public List<Object[]> getLanguagesWithPercentageGreaterThan89() {
        return countryRepository.findLanguagesWithPercentageGreaterThan89();
    }

    public List<Country> getCountriesWithAreaLessThan501AndPopulationGreaterThan100000() {
        return countryRepository.findCountriesWithAreaLessThan501AndPopulationGreaterThan100000();
    }

    public List<Country> getCountriesWithConstitutionalMonarchyAndAreaGreaterThan200AndLifeExpectancyGreaterThan75() {
        return countryRepository
                .findCountriesWithConstitutionalMonarchyAndAreaGreaterThan200AndLifeExpectancyGreaterThan75();
    }

    public List<Object[]> countCountriesByRegion() {
        return countryRepository.countCountriesByRegion();
    }
}
