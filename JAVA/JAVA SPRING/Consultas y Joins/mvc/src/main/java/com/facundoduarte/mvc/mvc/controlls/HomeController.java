package com.facundoduarte.mvc.mvc.controlls;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facundoduarte.mvc.mvc.models.City;
import com.facundoduarte.mvc.mvc.models.Country;
import com.facundoduarte.mvc.mvc.services.CityService;
import com.facundoduarte.mvc.mvc.services.CountryService;

@RestController
@RequestMapping("/")
public class HomeController {

    private final CountryService countryService;
    private final CityService cityService;

    public HomeController(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;

    }

    @GetMapping("CountriesSpeakingSlovene")
    public List<Object[]> getCountriesSpeakingSlovene() {
        return countryService.getCountriesSpeakingSlovene();
    }

    @GetMapping("totalCitiesPerCountry")
    public List<Object[]> getTotalCitiesPerCountry() {
        return countryService.getTotalCitiesPerCountry();
    }

    @GetMapping("CitiesInMexicoWithPopulationGreaterThan500000")
    public List<City> getCitiesInMexicoWithPopulationGreaterThan500000() {
        return cityService.getCitiesInMexicoWithPopulationGreaterThan500000();

    }

    @GetMapping("LanguagesWithPercentageGreaterThan89")
    public List<Object[]> getLanguagesWithPercentageGreaterThan89() {
        return countryService.getLanguagesWithPercentageGreaterThan89();
    }

    @GetMapping("CountriesWithAreaLessThan501AndPopulationGreaterThan100000")
    public List<Country> getCountriesWithAreaLessThan501AndPopulationGreaterThan100000() {
        return countryService.getCountriesWithAreaLessThan501AndPopulationGreaterThan100000();
    }

    @GetMapping("CountriesWithConstitutionalMonarchyAndAreaGreaterThan200AndLifeExpectancyGreaterThan75")
    public List<Country> getCountriesWithConstitutionalMonarchyAndAreaGreaterThan200AndLifeExpectancyGreaterThan75() {
        return countryService
                .getCountriesWithConstitutionalMonarchyAndAreaGreaterThan200AndLifeExpectancyGreaterThan75();
    }

    @GetMapping("CitiesInArgentinaBuenosAiresWithPopulationGreaterThan500000")
    public List<Object[]> getCitiesInArgentinaBuenosAiresWithPopulationGreaterThan500000() {
        return cityService.getCitiesInArgentinaBuenosAiresWithPopulationGreaterThan500000();
    }

    @GetMapping("countCountriesByRegion")
    public List<Object[]> countCountriesByRegion() {
        return countryService.countCountriesByRegion();
    }
}
