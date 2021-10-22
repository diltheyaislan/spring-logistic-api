CREATE TABLE delivery (
	id BIGINT auto_increment NOT NULL,
	client_id BIGINT NOT NULL,
	fee DECIMAL(10,2) NOT NULL,
	status varchar(20) NOT NULL,
	order_date DATETIME NOT NULL,
	completed_date DATETIME,
	
	recipient_name varchar(60) NOT NULL,
	recipient_address varchar(255) NOT NULL,
	recipient_address_number varchar(30) NOT NULL,
	recipient_address_additional varchar(60),
	recipient_address_district varchar(30) NOT NULL,
	
	PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_client
FOREIGN KEY (client_id) REFERENCES client (id);