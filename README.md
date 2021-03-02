# Semantic Bits Java and Angular coding challenge

This repository contains a barebones Java SpringBoot REST API, with further instructions for setting up an Angular frontend application. This coding exercise is designed for the SemanticBits technical interview.

You will find the necessary files and scripts for implementing the most basic of Java SpringBoot backends, one that will we will extend and build upon. Mock data is provided as a SQL script if you choose to load that locally, or you can use the pre-configured Docker container with Postgres.

The data this challenge uses is based on abstracted clinical trials, managed by NCI. This dataset is incredibly minimal and captures only the nct id, trial title, trial phase, and trial completion date. This sample data will provide us with plenty of opportunities to assess common CRUD operations and development without getting too detailed. This interview is focused heavily on functional implementation, problem solving, and resourcefulness.

The expectation is to implement CRUD operations within the backend, integrate with the database, and build a frontend using the Angular Javascript framework to consume the API. The SemanticBits interviewer will provide direction for application development as well as assitance with any questions or issues.

## Instructions

* Clone this repository somewhere on your local machine.
* The `data` directory contains mock data that you can use to load your local database instance with, otherwise it will be used by the Docker container to populate a Postgres instance.
* The `java-backend-api` directory is a partial implementation of our clinical trials REST API. More functionality will be added to this over the course of the interview.

## Getting ready for the interview

### Pre-requisites

* Maven 3
* Java 8 or above
* Docker (needed only if you choose to use the Postgres container provided)
* Latest stable version of Node
* Angular-CLI for the frontend section of our challenge

### Building the application

The application can be built quickly using the following:

* `cd java-backend-api`
* `mvn package`

### Running the application

Once the application is build, the following will run the backend API locally:

* `cd java-backend-api`
* `java -jar target/java-backend-api-0.1.0.jar`

### Accessing the API

Throughout the interview, you may be asked to request data from the now running API endpoints. Later, you will use these within the Angular frontend.

* `http://localhost:8080` (Application health check)
* `http://localhost:8080/clinicaltrial` (List of clinical trials)

### Setting up the database

You have the option to load the data file locally, or use the provided Postgres container. Either way, the default database port is typically 5432 with the username `postgres` and password set to `password`. The database will then have the data loaded into the `clinical_trial` table on the public schema.

* `psql -U <username> -d <dbname> -f ./data/data.sql`
* Optionally, `cd data && docker-compose up`

### Create an Angular frontend

Once the interviewers are satisfied with the backend development, you will be asked to create an Angular frontend. If network latency or other issues arise, you can find a stock install here ready to use.

* `cd` into a the directory that contains the `java-angular-challenge` repository.
* `ng new angular-frontend`

## Wrap up

Thanks for you interest in interviewing with SemanticBits! Once the interview has concluded, feel free to delete and remove any files from this interview.
