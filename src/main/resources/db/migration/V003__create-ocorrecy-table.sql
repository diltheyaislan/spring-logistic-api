CREATE TABLE ocorrency (
	id BIGINT auto_increment NOT NULL,
	delivery_id BIGINT NOT NULL,
	description TEXT NOT NULL,
	register_date DATETIME,
	
	PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

ALTER TABLE ocorrency ADD CONSTRAINT fk_ocorrency_delivery
FOREIGN KEY (delivery_id) REFERENCES delivery (id);