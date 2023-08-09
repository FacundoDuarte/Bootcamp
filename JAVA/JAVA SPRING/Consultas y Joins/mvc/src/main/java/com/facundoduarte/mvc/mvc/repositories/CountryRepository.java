package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
    // List<Country> findAll();
    @Query("SELECT c.name AS Pais, l.language AS Lenguaje, l.percentage AS Porcentaje " +
            "FROM Country c " +
            "JOIN c.languages l " +
            "WHERE l.language = 'Slovene' " +
            "ORDER BY l.percentage DESC")
    List<Object[]> findCountriesSpeakingSlovene();

    @Query("SELECT c.name AS Pais, COUNT(city) AS NumeroCiudades " +
            "FROM Country c " +
            "LEFT JOIN c.cities city " +
            "GROUP BY c.id, c.name " +
            "ORDER BY NumeroCiudades DESC")
    List<Object[]> findTotalCitiesPerCountry();

    @Query("SELECT c.name AS Pais, l.language AS Lenguaje, l.percentage AS Porcentaje " +
            "FROM Country c " +
            "JOIN c.languages l " +
            "WHERE l.percentage > 89 " +
            "ORDER BY l.percentage DESC")
    List<Object[]> findLanguagesWithPercentageGreaterThan89();

    @Query("SELECT c " +
            "FROM Country c " +
            "WHERE c.surfaceArea < 501 AND c.population > 100000")
    List<Country> findCountriesWithAreaLessThan501AndPopulationGreaterThan100000();

    @Query("SELECT c " +
            "FROM Country c " +
            "WHERE c.governmentForm = 'Constitutional Monarchy' " +
            "AND c.surfaceArea > 200 " +
            "AND c.lifeExpectancy > 75")
    List<Country> findCountriesWithConstitutionalMonarchyAndAreaGreaterThan200AndLifeExpectancyGreaterThan75();

    @Query("SELECT c.region AS Region, COUNT(c) AS NumeroPaises " +
            "FROM Country c " +
            "GROUP BY c.region " +
            "ORDER BY NumeroPaises DESC")
    List<Object[]> countCountriesByRegion();
}
