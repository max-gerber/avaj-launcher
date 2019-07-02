package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable{
	private WeatherTower weatherTower;
	public	JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
				this.announce("JetPlane#" + this.name + "(" + this.id + "): " + "Those people look like ants");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
				this.announce("JetPlane#" + this.name + "(" + this.id + "): " + "Fasten your seatbelts");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
				this.announce("JetPlane#" + this.name + "(" + this.id + "): " + "Time to let auto-pilot take over");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7); 
				this.announce("JetPlane#" + this.name + "(" + this.id + "): " + "The cockpit is freezing over!");
				break;
		}
		if (this.coordinates.getHeight() < 0){
			this.grounded = true;
			this.announce("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from the weather tower at (0, " + this.coordinates.getLatitude() + ", " + this.coordinates.getLongitude() + ")");
		}
	}
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		this.announce("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to the weather tower");
	}
}