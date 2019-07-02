package src.simulator;

import src.simulator.Tower;
import src.simulator.WeatherTower;
import src.vehicles.*;
import src.weather.*;
import src.exception.*;

// import java.io.IOException;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	public static void main(String[] args) throws InterruptedException {
		try {
			File file = new File("simulation.txt");
			file.delete();
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line != null){
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0){
					System.out.println("Invalid number of Simulations");
					System.exit(1);
				}
				while ((line = reader.readLine()) != null){
					try {
						Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
						flyables.add(flyable);
					} catch (AircraftException e){
						System.out.println(e.getMessage());
					}
				}
				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}
				for (int i = 0; i < simulations; i++) {
					weatherTower.changeWeather();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File " + args[0] + " not found.");
		} catch (IOException e) {
			System.out.println("There was an error reading file " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Please specify simulation file");
		}
	}
}