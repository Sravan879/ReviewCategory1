CREATE TABLE IF NOT EXISTS category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    description TEXT
);

CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    description TEXT,
    price DOUBLE,
    categoryId INT,
    FOREIGN KEY (categoryId) REFERENCES category(id)
);
