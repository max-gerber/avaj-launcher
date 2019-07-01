package src.weather;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	public		Coordinates(int longitude, int latitude, int height){
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height > 100 ? 100 : height;
	}
	public int	getLongitude() {
		return this.longitude;
	}
	public int	getLatitude() {
		return this.latitude;
	}
	public int	getHeight() {
		return this.height;
	}
}