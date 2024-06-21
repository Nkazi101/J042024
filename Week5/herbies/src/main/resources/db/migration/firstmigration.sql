
CREATE TABLE IF NOT EXISTS cars (
    id INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    color VARCHAR(255) NOT NULL,
    -- Add other columns as needed
    vin VARCHAR(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL
);

INSERT INTO cars (make, model, year, color, vin) 
SELECT 'Kia', 'Forte', 2021, 'Red', 'VN040594050'
FROM dual
WHERE NOT EXISTS (SELECT 1 FROM cars WHERE vin = 'VN040594050');

INSERT INTO users (first_name, last_name, birth_date, address, email, password, phone, role, active)
SELECT 'Nkazi', 'Sibanda', '1996-07-17', '6325 Victoria Ave', 'sibanda.nkazimulo@gmail.com', 'claim', '3146654673', 'SELLER', true
FROM dual
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'sibanda.nkazimulo@gmail.com');

INSERT INTO users (first_name, last_name, birth_date, address, email, password, phone, role, active)
SELECT 'Michael', 'Scott', '1985-03-12', '1500 Sesame Street', 'scottm@gmail.com', 'hello', '5176030622', 'SELLER', true
FROM dual
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'scottm@gmail.com');
