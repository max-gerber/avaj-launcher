package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class Aircraft {
	public Boolean grounded = false;
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;
	protected Aircraft(String name, Coordinates coordinates){
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}
	public Coordinates getCoordinates(){
		return(this.coordinates);
	}
	private static long nextId() {
		return idCounter++;
	}
	public String getName() {
		return this.name;
	}
	public Boolean isGrounded() {
		return this.grounded;
	}
}