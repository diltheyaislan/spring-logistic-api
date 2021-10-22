CREATE TABLE springlogistic.client (
	id BIGINT auto_increment NOT NULL,
	name varchar(60) NOT NULL,
	email varchar(255) NOT NULL,
	phone_number varchar(20) NOT NULL,
	PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;
