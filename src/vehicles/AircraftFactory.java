package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;
import src.exception.*;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AircraftException {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		switch(type){
			case "Baloon":
				return new Baloon(name, coordinates);
			case "Helicopter":
				return new Helicopter(name, coordinates);
			case "JetPlane":
				return new JetPlane(name, coordinates);
		}
		throw new AircraftException("Aircrafts of type " + type + " are forbidden in these parts");
	}
}