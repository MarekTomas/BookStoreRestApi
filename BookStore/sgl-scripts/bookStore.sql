##DROP USER IF EXISTS;
DROP USER IF EXISTS 'BookUser'@'localhost';

## CREATE USER
CREATE USER 'BookUser'@'localhost' IDENTIFIED BY '1qazXSW@';

## DROP DATABASE IF EXIST
drop database if exists bookStore;

## CREATE DATABASE
create database bookStore DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
use bookStore;

## DROP TABLES IF EXIST
drop table IF EXISTS Login; 
drop table IF EXISTS Books;


## CREATE TABLES
##create table Login (
  ##  id INT AUTO_INCREMENT,
  ##  login VARCHAR(25) NOT NULL,
  ##  password VARCHAR(25) NOT NULL,
##role VARCHAR(25) NOT NULL,
	##PRIMARY KEY (id),
##CONSTRAINT uq_loginRola UNIQUE (login, rola)
##);

create table books (
    id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
	author VARCHAR(255) NOT NULL,
    price INT,
	PRIMARY KEY (id)
    );
    
    
    
insert into Books 
(id,title,author,price) values
(1,'Bałutki. Kroniki Ziemi Obiecanej', 'Ewa Różycka',50),
(2,'Błoto', 'Hillary Jordan',39),
(3,'Dysforia Przypadki mieszczan polskich', 'Marcin Kołodziejczyk',19),
(4,'Historia twojego życia', 'Ted Chiang',59),
(5,'Jak pokochać centra handlowe', 'Natalia Fiedorczuk',15),
(6,'Kolekcja nietypowych zdarzeń', 'Tom Hanks',89),
(7,'Legenda o samobójstwie', 'David Vann',46),
(8,'Mam na imię Lucy', 'Elizabeth Strout',32),
(9,'Middlesex', 'Jeffrey Eugenides',89),
(10,'Miniaturzystka', 'Jessie Burton',96),
(11,'Nasz chłopak', 'Daniel Magariel',73),
(12,'Pierwszy bandzior', 'Miranda July',56),
(13,'Podróżowanie z Beniaminem', 'Martin Vopěnka',27),
(14,'Połówka żółtego słońca', 'Chimamanda Ngozi Adichie',45)
;

select id,title,author,price from Books;

