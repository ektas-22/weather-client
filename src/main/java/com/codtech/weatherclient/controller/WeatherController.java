package com.codtech.weatherclient.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codtech.weatherclient.model.WeatherResponse;
import com.codtech.weatherclient.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	private final WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping
	public WeatherResponse getWeather(@RequestParam double lat, @RequestParam double lon) {
		return weatherService.fetchWeather(lat, lon);
	}

	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e) {
		return "Error: " + e.getMessage();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String handleInvalidInput(IllegalArgumentException e) {
		return "Invalid input: " + e.getMessage();
	}
}
