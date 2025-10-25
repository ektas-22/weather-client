package com.codtech.weatherclient.service;

import com.codtech.weatherclient.model.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {
	private final ObjectMapper objectMapper = new ObjectMapper();

	public WeatherResponse fetchWeather(double latitude, double longitude) {
		if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException("Invalid latitude or longitude values");
		}

		String url = String.format(
				"https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&current_weather=true", latitude,
				longitude);

		int attempts = 0;
		int maxRetries = 3;

		while (attempts < maxRetries) {
			try {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

				if (response.statusCode() != 200) {
					throw new RuntimeException("HTTP error: " + response.statusCode());
				}

				// Optional: log raw JSON
				System.out.println("Raw JSON: " + response.body());

				return objectMapper.readValue(response.body(), WeatherResponse.class);

			} catch (Exception e) {
				attempts++;
				System.err.println("Attempt " + attempts + " failed: " + e.getMessage());
				if (attempts >= maxRetries) {
					return null; // fallback: return null or a default WeatherResponse
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {
				}
			}
		}
		return null;
	}
}
