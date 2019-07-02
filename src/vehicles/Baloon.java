package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class Baloon extends Aircraft implements Flyable{
		private WeatherTower weatherTower;
		Baloon(String name, Coordinates coordinates){
			super(name, coordinates);
		}
		public void updateConditions() {
			String weather = this.weatherTower.getWeather(this.coordinates);
			switch (weather) {
				case "SUN":
					this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
					this.announce("Baloon#" + this.name + "(" + this.id + "): " + "Great weather for ballooning");
					break;
				case "RAIN":
					this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
					this.announce("Baloon#" + this.name + "(" + this.id + "): " + "Well this puts a damper on things");
					break;
				case "FOG":
					this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
					this.announce("Baloon#" + this.name + "(" + this.id + "): " + "I can't see!");
					break;
				case "SNOW":
					this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
					this.announce("Baloon#" + this.name + "(" + this.id + "): " + "C-c-ca-can w-we l-and now??");
					break;
			}
			if (this.coordinates.getHeight() < 0){
				this.grounded = true;
				this.announce("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from the weather tower at (0, " + this.coordinates.getLatitude() + ", " + this.coordinates.getLongitude() + ")");
			}
		}
		public void registerTower(WeatherTower weatherTower) {
			this.weatherTower = weatherTower;
			this.weatherTower.register(this);
			this.announce("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to the weather tower");
		}
}