package src.weather;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

import java.util.Random;

public class WeatherProvider {
	private WeatherProvider weatherProvider;
	private static String[] weather = {"SNOW", "RAIN", "FOG", "SUN"};
	private WeatherProvider() {
		this.weatherProvider = this;
	}
	public WeatherProvider getProvider() {
		return this.weatherProvider;
	}
	public static String getCurrentWeather(Coordinates coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		Random rand = new Random();
		if (((longitude + latitude + height + rand.nextInt(4)) % 4) != 0){
			return weather[0];
		}
		return weather[((longitude + latitude + height + rand.nextInt(4)) % 3) + 1];
	}
}