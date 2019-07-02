package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;
	public	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
				this.announce("Helicopter#" + this.name + "(" + this.id + "): " + "Perfect weather for trip");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
				this.announce("Helicopter#" + this.name + "(" + this.id + "): " + "Oooh, romantic!");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
				this.announce("Helicopter#" + this.name + "(" + this.id + "): " + "I'm pretty sure the cliff face is still far away...");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				this.announce("Helicopter#" + this.name + "(" + this.id + "): " + "I'm getting too cold for this shit");
				break;
		}
		if (this.coordinates.getHeight() < 0){
			this.grounded = true;
			this.announce("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from the weather tower at (0, " + this.coordinates.getLatitude() + ", " + this.coordinates.getLongitude() + ")");
		}
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		this.announce("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to the weather tower");
	}
}