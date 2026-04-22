Hospital Management System (Java Web)
📌 Overview

This project is a Java Web Application built using JSP, Servlets, and JDBC.
It helps manage basic hospital operations like:

👨‍⚕️ Doctor Management
🧑‍🤝‍🧑 Patient Registration
📅 Appointment Booking

This project follows a simple MVC architecture and is designed for learning Java Web development.

🚀 Features
Add and view doctors
Register and manage patients
Book appointments
Dynamic doctor dropdown in appointment form
Display data in tables (Doctor, Patient, Appointment)
Basic login system
MySQL database integration
🛠️ Tech Stack
Java (JDK 8+)
JSP & Servlets
JDBC
MySQL
Apache Tomcat
Bootstrap (for UI)
📂 Project Structure
src/
  com.model
  com.service
  com.service.impl
  com.servlets

WebContent/
  *.jsp
  WEB-INF/
⚙️ Setup Instructions

Clone the repository

git clone https://github.com/your-username/hospital-management-system-java.git
Import into Eclipse / IntelliJ
Configure Apache Tomcat Server

Create MySQL database:

CREATE DATABASE hospital;
Update DB credentials in DBConnection.java
Run the project on server
