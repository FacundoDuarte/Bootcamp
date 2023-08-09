package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.City;

public interface CityRepository extends CrudRepository<City, Integer> {
    @Query("SELECT city " +
            "FROM City city " +
            "JOIN city.country country " +
            "WHERE country.name = 'Mexico' AND city.population > 500000 " +
            "ORDER BY city.population DESC")
    List<City> findCitiesInMexicoWithPopulationGreaterThan500000();

    @Query("SELECT c.country.name AS Pais, c.name AS Ciudad, c.district AS Distrito, c.population AS Poblacion " +
            "FROM City c " +
            "WHERE c.country.name = 'Argentina' AND c.district = 'Buenos Aires' AND c.population > 500000")
    List<Object[]> findCitiesInArgentinaBuenosAiresWithPopulationGreaterThan500000();
}
