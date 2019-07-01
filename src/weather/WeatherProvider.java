package src.weather;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class WeatherProvider {
	private WeatherProvider weatherProvider;
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
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
		return weather[(longitude * latitude * height) % 4];
	}
}