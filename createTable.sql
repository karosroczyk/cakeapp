DROP SCHEMA IF EXISTS `cakeapp`;
CREATE SCHEMA `cakeapp`;
use `cakeapp`;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `ingredient`;
-- Create the ingredient table
CREATE TABLE ingredient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity VARCHAR(255) NOT NULL,
    cake_id INT,
    FOREIGN KEY (cake_id) REFERENCES cake(id),
    CONSTRAINT UIngredient UNIQUE (name,cake_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cake`;
-- Create the cake table
CREATE TABLE cake (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
