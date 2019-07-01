package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) /*throws InputException */{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		switch(type){
			case "Baloon":
				return Baloon(name, coordinates);
			case "Helicopter":
				return Helicopter(name, coordinates);
			case "JetPlane":
				return JetPlane(name, coordinates);
		}
		/*throw new InputException("Aircrafts of type " + type + " are forbidden in these parts");*/
	}
}