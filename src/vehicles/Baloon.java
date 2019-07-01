package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class Baloon extends Aircraft{
	private WeatherTower weatherTower;
	Baloon(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
				System.out.println("Great weather for ballooning");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
				System.out.println("Well this puts a damper on things");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
				System.out.println("I can't see!");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
				System.out.println("C-c-ca-can w-we l-and now??");
				break;
		}
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}