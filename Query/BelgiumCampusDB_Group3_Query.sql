DROP DATABASE IF EXISTS BelgiumCampusDB_Group3;
CREATE DATABASE BelgiumCampusDB_Group3;
USE BelgiumCampusDB_Group3;

 CREATE TABLE Administrator (
 admin_id INT NOT NULL AUTO_INCREMENT,
 admin_name VARCHAR(50) NOT NULL,
 admin_password VARCHAR(50) NOT NULL,
 admin_contact VARCHAR(10) NOT NULL,
 PRIMARY KEY (Admin_id));
 
CREATE TABLE Student (
 student_id INT NOT NULL AUTO_INCREMENT,
 student_name VARCHAR(50) NOT NULL,
 student_address VARCHAR(50) NOT NULL,
 student_email VARCHAR(50) NOT NULL,
 student_password VARCHAR(50) NOT NULL,
 PRIMARY KEY (student_id));
 
 CREATE TABLE Register (
 register_id INT NOT NULL AUTO_INCREMENT,
 student_id INT NOT NULL,
 course_name VARCHAR(50) NOT NULL,
 PRIMARY KEY (register_id),
 FOREIGN KEY (student_id) REFERENCES Student(student_id));
 
 INSERT INTO Administrator VALUES (1,"Andre", "12345", "0760433125"); 
 INSERT INTO Administrator VALUES (2,"Michael", "54321", "0823466217");
 
 INSERT INTO Student VALUES (1, "De Raven", "19 Eekhoring Street Theresapark", "deraven123@gmail.com", "12345"); 
 INSERT INTO Student VALUES (2, "Gustav", "25 Waterbok Street Ninapark", "gustav647@gmail.com", "Gu123");
 
 INSERT INTO Register VALUES (1, 1, "PRG381"); 
 INSERT INTO Register VALUES (2, 1, "MAT381");
 INSERT INTO Register VALUES (3, 1, "LPR381");
 INSERT INTO Register VALUES (4, 1, "DBD381");
 INSERT INTO Register VALUES (5, 1, "RSH381");
 INSERT INTO Register VALUES (6, 2, "MAT381");
 INSERT INTO Register VALUES (7, 2, "LPR381");
 INSERT INTO Register VALUES (8, 2, "DBD381");
 INSERT INTO Register VALUES (9, 2, "PRJ381");
 INSERT INTO Register VALUES (10, 2, "RSH381");
