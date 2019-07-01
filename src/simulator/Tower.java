package src.simulator;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;

import java.util.*;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();
	public void register(Flyable flyable) {
		observers.add(flyable);
	};
	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}
	protected void conditionsChanged() {
		for (Flyable flyable : observers){
			flyable.updateConditions();
		}
	}
}