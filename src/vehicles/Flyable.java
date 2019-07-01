package src.vehicles;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
	public Boolean isGrounded();
}