package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class Helicopter extends Aircraft{
	private WeatherTower weatherTower;
	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
				System.out.println("Perfect weather for trip");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
				System.out.println("Oooh, romantic!");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
				System.out.println("I'm pretty sure the cliff face is still far away...");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				System.out.println("I'm getting too cold for this shit");
				break;
		}
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}