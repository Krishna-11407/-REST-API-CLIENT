package com.weatherapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class WeatherApp {
    private static final String API_KEY = "API_KEY";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Weather Information System ===");
            System.out.println("1. Get Weather Information");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    getWeatherData(city);
                    break;
                case 2:
                    System.out.println("Thank you for using Weather Information System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void getWeatherData(String city) {
        try {
            String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
            System.out.println("Fetching weather data from: " + urlString);
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                displayWeatherData(response.toString());
            } else {
                System.out.println("Error: " + responseCode);
                if (responseCode == 401) {
                    System.out.println("Invalid API key. Please check your API key on OpenWeatherMap website.");
                    System.out.println("Note: New API keys take 2-3 hours to activate after creation.");
                    System.out.println("Steps to check your API key:");
                    System.out.println("1. Go to https://openweathermap.org/");
                    System.out.println("2. Log in to your account");
                    System.out.println("3. Go to your API keys section");
                    System.out.println("4. Check if the API key is activated");
                } else if (responseCode == 404) {
                    System.out.println("City not found. Please check the city name and try again.");
                } else {
                    System.out.println("Unexpected error. Please try again later.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }

    private static void displayWeatherData(String jsonData) {
        try {
            JSONObject json = new JSONObject(jsonData);
            JSONObject main = json.getJSONObject("main");
            JSONObject wind = json.getJSONObject("wind");
            JSONObject weather = json.getJSONArray("weather").getJSONObject(0);

            System.out.println("\n=== Weather Information ===");
            System.out.println("City: " + json.getString("name") + ", " + json.getJSONObject("sys").getString("country"));
            System.out.println("Temperature: " + main.getDouble("temp") + "°C");
            System.out.println("Humidity: " + main.getInt("humidity") + "%");
            System.out.println("Wind Speed: " + wind.getDouble("speed") + " m/s");
            System.out.println("Description: " + weather.getString("description"));
        } catch (Exception e) {
            System.out.println("Error parsing weather data: " + e.getMessage());
        }
    }
} 
