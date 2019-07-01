package src.simulator;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

public class WeatherTower extends Tower{
	public String	getWeather(Coordinates coordinates) {
		return(WeatherProvider.getCurrentWeather(coordinates));
	}
	void			changeWeather(){
		super.conditionsChanged();
	}
}