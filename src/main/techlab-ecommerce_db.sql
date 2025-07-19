CREATE DATABASE IF NOT EXISTS techlabdb;
USE techlabdb;

CREATE TABLE IF NOT EXISTS producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio DOUBLE,
    categoria VARCHAR(100),
    imagen_url VARCHAR(500),
    stock INT
);
