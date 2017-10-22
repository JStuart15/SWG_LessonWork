-- -----------------------------------------------------
-- Schema SuperPeopleSightings
-- -----------------------------------------------------
DROP DATABASE IF EXISTS SuperPeopleSightings;

-- -----------------------------------------------------
-- Schema SuperPeopleSightings
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS SuperPeopleSightings;
USE SuperPeopleSightings;

-- -----------------------------------------------------
-- Table super_powers
-- -----------------------------------------------------
DROP TABLE IF EXISTS super_powers;

CREATE TABLE IF NOT EXISTS super_powers (
  super_power_id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(45) NOT NULL,
  PRIMARY KEY (super_power_id)
  );

-- -----------------------------------------------------
-- Table super_people
-- -----------------------------------------------------
DROP TABLE IF EXISTS super_people;

CREATE TABLE IF NOT EXISTS super_people (
  super_person_id INT NOT NULL AUTO_INCREMENT,
  super_power_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(255) NULL,
  PRIMARY KEY (super_person_id),
  FOREIGN KEY (super_power_id) REFERENCES super_powers (super_power_id)
  );

-- -----------------------------------------------------
-- Table organizations
-- -----------------------------------------------------
DROP TABLE IF EXISTS organizations;

CREATE TABLE IF NOT EXISTS organizations (
  organization_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(255) NULL,
  street VARCHAR(45) NULL,
  city VARCHAR(45) NULL,
  state CHAR(2) NULL,
  zip CHAR(10) NULL,
  phone CHAR(10) NULL,
  PRIMARY KEY (organization_id)
  );

-- -----------------------------------------------------
-- Table locations
-- -----------------------------------------------------
DROP TABLE IF EXISTS locations;

CREATE TABLE IF NOT EXISTS locations (
  location_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  description VARCHAR(45) NULL,
  street VARCHAR(45) NULL,
  city VARCHAR(45) NULL,
  state CHAR(2) NULL,
  zip CHAR(10) NULL,
  latitude DECIMAL(10,8) NULL,
  longitude DECIMAL(10,8) NULL,
  isActive TINYINT(1) NULL,
  PRIMARY KEY (location_id)
  );

-- -----------------------------------------------------
-- Table sightings
-- -----------------------------------------------------
DROP TABLE IF EXISTS sightings;

CREATE TABLE IF NOT EXISTS sightings (
  sighting_id INT NOT NULL AUTO_INCREMENT,
  location_id INT NOT NULL,
  date DATE NOT NULL,
  PRIMARY KEY (sighting_id),
  FOREIGN KEY (location_id) REFERENCES locations (location_id)    
  );

-- -----------------------------------------------------
-- Table super_people_organizations
-- -----------------------------------------------------
DROP TABLE IF EXISTS super_people_organizations;

CREATE TABLE IF NOT EXISTS super_people_organizations (
  super_person_id INT NOT NULL,
  organization_id INT NOT NULL,
  PRIMARY KEY (super_person_id, organization_id),
  FOREIGN KEY (super_person_id) REFERENCES super_people (super_person_id),
  FOREIGN KEY (organization_id) REFERENCES organizations (organization_id)
  );

-- -----------------------------------------------------
-- Table super_people_sightings
-- -----------------------------------------------------
DROP TABLE IF EXISTS super_people_sightings;

CREATE TABLE IF NOT EXISTS super_people_sightings (
  super_person_id INT NOT NULL,
  sighting_id INT NOT NULL,
  PRIMARY KEY (super_person_id, sighting_id),
  FOREIGN KEY (super_person_id) REFERENCES super_people (super_person_id),
  FOREIGN KEY (sighting_id) REFERENCES sightings (sighting_id)
  );

