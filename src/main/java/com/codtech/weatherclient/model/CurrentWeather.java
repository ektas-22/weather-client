package com.codtech.weatherclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {
	private double temperature;
	private double windspeed;
	private double winddirection;
	private String time;
	private int weathercode;

	// Getters and setters
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(double windspeed) {
		this.windspeed = windspeed;
	}

	public double getWinddirection() {
		return winddirection;
	}

	public void setWinddirection(double winddirection) {
		this.winddirection = winddirection;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getWeathercode() {
		return weathercode;
	}

	public void setWeathercode(int weathercode) {
		this.weathercode = weathercode;
	}
}
