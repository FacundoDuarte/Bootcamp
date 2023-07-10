-- QUERY 1 
SELECT countries.name, languages.language, languages.percentage from countries
JOIN languages
ON languages.country_id = countries.id
WHERE languages.language = 'Slovene'
order by languages.percentage DESC;

-- QUERY 2
SELECT countries.name, count(countries.code) as cities from cities
JOIN countries
ON countries.code = cities.country_code
GROUP BY countries.code
ORDER BY cities DESC;

-- -- QUERY 3
SELECT cities.name, cities.population, countries.code FROM countries 
JOIN cities
ON cities.country_code = countries.code
WHERE countries.code = 'MEX';

-- -- QUERY 4
SELECT countries.name, languages.language, languages.percentage from languages
JOIN countries
ON countries.code = languages.country_code
WHERE percentage > 89
order by percentage DESC;

-- -- 	QUERY 5
SELECT countries.name, countries.population, countries.surface_area from countries
WHERE surface_area < 501 and population > 100000;

-- QUERY 6
SELECT countries.name, countries.government_form, countries.capital, countries.life_expectancy FROM countries
WHERE government_form = "Constitutional Monarchy" AND capital > 200 AND life_expectancy > 75;

-- QUERY 7
SELECT countries.name, cities.name, cities.district, cities.population FROM cities
JOIN countries
ON countries.code = cities.country_code
WHERE countries.code = "ARG" AND cities.district = "Buenos Aires" and cities.population > 500000;

-- QUERY 8
SELECT countries.region, COUNT(countries.id) AS countries
FROM countries
GROUP BY region
ORDER BY countries DESC;

