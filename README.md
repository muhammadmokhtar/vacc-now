# Vacc-Now Springboot Project 

## Table of Contents

* [Overview](#Overview)
* [Pre-requests](#Pre-requests)
* [Project-Running-Instructions](#Project-Running-Instructions)
* [Feature-Details](#Feature-Details)

## Overview

VaccNow is an healthcare organization managing the process of Covid-19 vaccine to public
This project provides some of the APIs for basic faetures 

## Pre-requests

Please make sure you have the following software for running project on your local machine:

1. Docker (optional)
1. MySQL: MySQL is the used DB for this project you can install it locally or you can pull and run a MySQL image from docker with command:
   `docker run -it -e MYSQL_ROOT_PASSWORD=root --rm --name mysql -p 3306:3306 -p 33060:33060 mysql`
1. Java 8+ 
1. apache-maven
1. Postman (optional)

## Project-Running-Instructions

First make sure you have ${MYSQL_DB_USERNAME} and ${MYSQL_DB_PASSWORD} environment variables locally:
You can do this manually or by running the following script at power shell for windows:

`[System.Environment]::SetEnvironmentVariable('MYSQL_DB_USERNAME','<your_user_name>',[System.EnvironmentVariableTarget]::Machine)
 [System.Environment]::SetEnvironmentVariable('MYSQL_DB_PASSWORD','<your_password>',[System.EnvironmentVariableTarget]::Machine)`

Then run `maven clean install` at the path of src folder then `cd target` and `java -jar vaccnow-0.0.1-SNAPSHOT.jar`

## Feature-Details

There is a `data.sql` file provided under `src\main\resources`, you can run on the mysql db for having some seed data at application.
There is a post man collection file `vacc-now.postman_collection.json` provided at root path you can import at Postman and try the API' requests.



