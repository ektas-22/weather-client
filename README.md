🌦️ REST API Client – Weather Application
💼 Internship Task – CodTech

This project is a Spring Boot-based REST API Client that consumes a public weather API and displays current weather data in a structured JSON format.
It demonstrates the ability to handle HTTP requests, parse JSON responses, and manage API integration in a Java backend application.

🚀 Project Overview

The application consumes the Open-Meteo Public API to fetch live weather data based on latitude and longitude coordinates.
It then parses the JSON response into a structured Java model and returns the result via a RESTful endpoint.

🧩 Features

✅ Fetches current weather data from a public REST API
✅ Handles HTTP GET requests using Spring Boot’s RestTemplate
✅ Parses and maps JSON responses to Java objects using Jackson
✅ Implements error handling for API or network issues
✅ Lightweight and easy to run

⚙️ Technologies Used
Technology	Purpose
Java 17+	Core programming language
Spring Boot 3.x	REST API framework
RestTemplate	For calling external APIs
Jackson	For JSON serialization/deserialization
Maven	Dependency management
Open-Meteo API	Public weather data source
🏗️ Project Structure
weather-client/
│
├── src/main/java/com/codtech/weatherclient/
│   ├── WeatherClientApplication.java        # Main application
│   ├── controller/
│   │   └── WeatherController.java           # REST Controller (GET /weather)
│   ├── service/
│   │   └── WeatherService.java              # Fetches data from Open-Meteo API
│   └── model/
│       ├── WeatherResponse.java             # Maps JSON response
│       └── CurrentWeather.java              # Nested weather object
│
├── src/main/resources/
│   └── application.properties               # App configuration (port, etc.)
│
└── pom.xml                                  # Maven dependencies

🔧 How to Run

Clone the Repository

git clone https://github.com/<your-username>/weather-client.git
cd weather-client


Build the Project

mvn clean install


Run the Application

mvn spring-boot:run


Access the API Endpoint

Open your browser or use Postman/cURL:

GET http://localhost:8080/weather?lat=28.61&lon=77.20


Example Response:

{
  "latitude": 28.625,
  "longitude": 77.25,
  "current_weather": {
    "time": "2025-10-17T14:15",
    "temperature": 25.6,
    "windspeed": 1.1,
    "winddirection": 180
  }
}

🧠 Error Handling

Handles missing or invalid parameters

Gracefully catches network or API errors

Uses @JsonIgnoreProperties(ignoreUnknown = true) to handle unexpected JSON fields

🧾 Example API Reference

Public API Used: Open-Meteo Weather API

Sample Request:

https://api.open-meteo.com/v1/forecast?latitude=28.61&longitude=77.20&current_weather=true

🧑‍💻 Author

Name: Ekta
Internship: CodTech Internship
Task: REST API Client – Java (Spring Boot)
