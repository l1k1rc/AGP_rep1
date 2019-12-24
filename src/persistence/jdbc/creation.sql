CREATE TABLE entry (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	simulation_duration INT,
	cashier_count INT,
	min_service_time INT,
	max_service_time INT,
	client_arrival_interval INT,
	priority_client_rate DOUBLE, 
	client_patience_time INT
);
CREATE TABLE client (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	arrival_time INT,
	service_start_time INT,
	departure_time INT,
	is_served BOOLEAN,
	priority BOOLEAN,
	entry_id INT,
	FOREIGN KEY (entry_id) REFERENCES entry(id)
);