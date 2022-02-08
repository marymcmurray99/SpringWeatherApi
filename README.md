# Spring Weather Api 

## Overview
This project is a Spring Boot Java API for obtaining weather data. 

## Endpoints 
This project has 2 endpoints that each require a 20 character Bearer token. 

### Current Weather Data endpoint
This endpoint can be reached by the url
```/current-weather-data/{zipcode}```
where
- zipcode is the zipcode you want weather for 
- the header contains Bearer token of the format ```Authorization: Bearer {20 char token}```
### Weather Forcast endpoint 
This endpoint can be reached at 
```/weather-forcast/{zipcode}``` where
- zipcode is the zipcode you want weather for
- the header contains Bearer token of the format ```Authorization: Bearer {20 char token}```

## Running

To run this project, you can 

- set up an IntelliJ project and run it in the IDE and access the api via Postman or your browser at ```http://localhost:8080/{url}```
