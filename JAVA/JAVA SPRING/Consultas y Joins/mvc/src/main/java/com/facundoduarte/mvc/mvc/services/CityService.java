package com.facundoduarte.mvc.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.City;
import com.facundoduarte.mvc.mvc.repositories.CityRepository;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCitiesInMexicoWithPopulationGreaterThan500000() {
        return cityRepository.findCitiesInMexicoWithPopulationGreaterThan500000();
    }

    public List<Object[]> getCitiesInArgentinaBuenosAiresWithPopulationGreaterThan500000() {
        return cityRepository.findCitiesInArgentinaBuenosAiresWithPopulationGreaterThan500000();
    }
}
