INSERT INTO users (username, password, enabled, email)
VALUES
('user', '$2y$10$Asnk2HVhhHTwlOur0beC8.SQSHd.zOCKidUPIJYC4xSKy/CAxToQy', TRUE, 'dummy@novi.nl'),
('admin', '$2y$10$Asnk2HVhhHTwlOur0beC8.SQSHd.zOCKidUPIJYC4xSKy/CAxToQy', TRUE, 'dummy@novi.nl');

INSERT INTO authorities (username, authority)
VALUES
('user', 'ROLE_USER'),
('admin', 'ROLE_USER'),
('admin', 'ROLE_ADMIN');

INSERT INTO customers (name)
VALUES
('Johannes'),
('Fleur');

INSERT INTO memberships (name, price, type_of_horse_stall, customer_id)
VALUES
('Weekabonnement','€ 9,95','Paardenbox', 1),
('Maandabonnement','€ 29,95','Paardencontainer', 2);

INSERT INTO horse_stalls (name, size, type)
VALUES
('Bliksem','30 m2','Actiefstal'),
('Belle','40 m2','Loopstal');

INSERT INTO horses (name, food_type, copy_passport, horse_stall_id)
VALUES
('Stormy','Gras', true, 1),
('Lucky','Hooi', false, 2);

