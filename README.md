# -REST-API-CLIENT

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: Motheraju Krishna Prasad

*INTERN ID*: CT04DA187

*DOMAIN*: JAVA PROGRAMMING

*DURATION*: 4 WEEEKS

*MENTOR*: NEELA SANTOSH

## Project Description
I developed this Java application as part of my learning journey in API integration and Java programming. The application fetches real-time weather data from OpenWeatherMap's free API and displays it in a user-friendly format. I used VS Code as my IDE and took help from various resources like ChatGPT, Google, and YouTube tutorials to understand API integration concepts and Java programming best practices.

The application uses OpenWeatherMap's Current Weather Data API, which provides comprehensive weather information for any city worldwide. I obtained my API key (12a59f76d0459e9ccc24f8068d81d599) by signing up on OpenWeatherMap's website (https://openweathermap.org/). The API key is free for personal use and allows up to 60 calls per minute, which is more than sufficient for this application.

The program features a simple command-line interface that allows users to:
- Get current weather information for any city
- View temperature in Celsius
- Check humidity levels
- Monitor wind speed
- See weather descriptions

I implemented proper error handling to manage various scenarios like invalid city names, API key issues, and network connectivity problems. The application uses Maven for dependency management and includes the org.json library for parsing JSON responses from the API.

## Project Structure
```
weather-api-client/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── weatherapp/
│                   └── WeatherApp.java
├── target/
│   ├── classes/
│   └── weather-api-client-1.0-SNAPSHOT-jar-with-dependencies.jar
├── pom.xml
└── README.md
```

## Features
- Real-time weather data fetching
- User-friendly command-line interface
- Comprehensive error handling
- Metric system measurements
- Detailed weather information display

## Prerequisites
- Java 11 or higher
- Maven
- Internet connection
- OpenWeatherMap API key (included in the code)

## Setup and Running
1. Clone the repository
2. Navigate to the project directory
3. Build the project using Maven:
   ```
   mvn clean package
   ```
4. Run the application:
   ```
   java -jar target/weather-api-client-1.0-SNAPSHOT-jar-with-dependencies.jar
   ```

## Usage
1. Choose option 1 to get weather information
2. Enter a city name
3. View the weather details
4. Choose option 2 to exit

## Example Output
```
=== Weather Information System ===
1. Get Weather Information
2. Exit
Enter your choice: 1
Enter city name: London

=== Weather Information ===
City: London, GB
Temperature: 15.5°C
Humidity: 65%
Wind Speed: 3.2 m/s
Description: cloudy
```

## Error Handling
The application handles various error cases:
- Invalid city names
- API key issues
- Network connectivity problems
- Invalid user input
