-- QUERY 1
SELECT city.city_id, city.city, customer.first_name, customer.last_name, customer.email, address.address FROM customer
JOIN address
ON customer.address_id = address.address_id
JOIN city
ON city.city_id = address.city_id
WHERE address.city_id = 312;

-- QUERY 2
SELECT film.film_id, film.title, film.description, film.release_year, film.rating, film.special_features, category.name FROM film
JOIN film_category
ON film.film_id = film_category.film_id
JOIN category
ON category.category_id = film_category.category_id
WHERE film_category.category_id = 5;

-- QUERY 3
SELECT actor.actor_id, concat(actor.first_name, " " ,actor.last_name) as actor_name, film_actor.film_id, film.title, film.description, film.release_year FROM actor 
JOIN film_actor
ON film_actor.actor_id = actor.actor_id
JOIN film
ON film.film_id = film_actor.film_id
WHERE film_actor.actor_id = 5;

-- QUERY 4
SELECT customer.store_id, address.city_id, customer.first_name, customer.last_name, customer.email, address.address FROM customer
JOIN address
ON address.address_id = customer.address_id
WHERE (address.city_id = 1 OR address.city_id = 42 OR address.city_id= 312 OR  address.city_id = 459) AND customer.store_id = 1;

-- QUERY 5
SELECT film.title, film.description, film.release_year, film.rating, film.special_features FROM film
JOIN film_actor
on film.film_id = film_actor.film_id
WHERE film.rating = "G" AND film.special_features LIKE '%behind the scenes%' AND film_actor.actor_id = 15;

-- QUERY 6
SELECT film.film_id, film.title, actor.actor_id, concat(actor.first_name, " " ,actor.last_name) as actor_name  FROM film_actor
JOIN film
ON film.film_id = film_actor.film_id
JOIN actor
ON actor.actor_id = film_actor.actor_id
WHERE film.film_id = 369;

-- QUERY 7
SELECT film.film_id, film.title, film.description, film.release_year, film.special_features, category.name as genre, film.rental_rate FROM film
JOIN film_category
ON film.film_id = film_category.film_id
JOIN category 
ON category.category_id = 7
WHERE film_category.category_id = 7 AND film.rental_rate = 2.99;

-- QUERY 8
SELECT actor.actor_id, concat(actor.first_name, " " ,actor.last_name) as actor_name, film.film_id, film.title, film.description, film.release_year,
film.rating, film.special_features, category.name as genre FROM actor
JOIN film_actor
ON film_actor.actor_id = actor.actor_id
JOIN film_category
ON film_category.film_id = film_actor.film_id
JOIN film
ON film.film_id = film_actor.film_id
JOIN category 
ON category.category_id = film_category.category_id
WHERE actor.actor_id = 23 AND film_category.category_id = 1;