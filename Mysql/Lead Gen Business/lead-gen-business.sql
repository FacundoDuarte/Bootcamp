-- QUERY 1
SELECT monthname("2012/03/01") as month, SUM(billing.amount) as revenue from billing
WHERE billing.charged_datetime >= "2012/03/01" AND billing.charged_datetime < "2012/04/01";

-- QUERY 2
SELECT billing.client_id, SUM(billing.amount) as total_revenue from billing
WHERE billing.client_id = 2;

-- QUERY 3
SELECT sites.domain_name, clients.client_id FROM sites
JOIN clients
ON clients.client_id = sites.client_id
WHERE clients.client_id = 10;

-- QUERY 4
SELECT clients.client_id, count(sites.domain_name) as number_of_websites, monthname(sites.created_datetime) as month_created, year(sites.created_datetime) as year_created
FROM clients
JOIN sites
ON sites.client_id = clients.client_id
WHERE clients.client_id = 1
GROUP BY sites.domain_name;

-- QUERY 4.1
SELECT clients.client_id, count(sites.domain_name) as number_of_websites, monthname(sites.created_datetime) as month_created, year(sites.created_datetime) as year_created
FROM clients
JOIN sites
ON sites.client_id = clients.client_id
WHERE clients.client_id = 20
GROUP BY sites.domain_name;

-- QUERY 5
SELECT sites.domain_name as website, count(sites.domain_name) as number_of_leads, DATE_FORMAT(leads.registered_datetime, "%M %d, %Y") as date_generated FROM leads
JOIN sites
ON sites.site_id = leads.site_id
WHERE leads.registered_datetime >= "2011/01/01" AND leads.registered_datetime <= "2011/02/15"
GROUP BY sites.domain_name;

-- QUERY 6
SELECT concat(clients.first_name, " ", clients.last_name) as client_name, count(clients.client_id) as number_of_leads FROM leads
JOIN sites
ON sites.site_id = leads.site_id
JOIN clients
ON clients.client_id = sites.client_id
WHERE leads.registered_datetime >= "2011/01/01" AND leads.registered_datetime <= "2011/12/31"
GROUP BY clients.client_id;

-- QUERY 7
SELECT concat(clients.first_name, " ", clients.last_name) as client_name, count(clients.client_id) as number_of_leads, monthname(leads.registered_datetime) as month_created from leads
JOIN sites
ON sites.site_id = leads.site_id
JOIN clients
ON clients.client_id = sites.client_id
WHERE leads.registered_datetime >= "2011/01/01" AND leads.registered_datetime <= "2011/06/30"
GROUP BY leads.leads_id;

-- QUERY 8
SELECT concat(clients.first_name, " ", clients.last_name) as client_name, sites.domain_name AS website, COUNT(leads.leads_id) AS total_clientes_potenciales
FROM clients 
INNER JOIN sites ON clients.client_id = sites.client_id
INNER JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-12-31'
GROUP BY clients.client_id, sites.site_id
ORDER BY clients.client_id;

-- 8.1
SELECT concat(clients.first_name, " ", clients.last_name) as client_name, sites.domain_name AS website, COUNT(leads.leads_id) AS total_clientes_potenciales
FROM clients
JOIN sites ON clients.client_id = sites.client_id
JOIN leads ON sites.site_id = leads.site_id
GROUP BY clients.client_id, sites.site_id
ORDER BY clients.client_id;

-- QUERY 9
SELECT concat(clients.first_name, " ", clients.last_name) as client_name, amount as total_Revenue, monthname(billing.charged_datetime) as month_charge,
year(billing.charged_datetime) as year_charge FROM clients
JOIN billing ON clients.client_id = billing.client_id
GROUP BY clients.client_id, concat(clients.first_name, " ", clients.last_name), YEAR(billing.charged_datetime), MONTH(billing.charged_datetime)
ORDER BY clients.client_id, YEAR(billing.charged_datetime), MONTH(billing.charged_datetime);

-- QUERY 10 
SELECT clients.client_id AS id_cliente, concat(clients.first_name, " ", clients.last_name) as client_name, GROUP_CONCAT(sites.domain_name SEPARATOR '/ ') AS sitios
FROM clients 
JOIN sites ON clients.client_id = sites.client_id
GROUP BY clients.client_id, concat(clients.first_name, " ", clients.last_name);
