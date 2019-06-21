import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	public static void main(String[] args) {
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(args[0]));
			String line = buffReader.readLine();
			if (line){
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0){
					System.out.println("Invalid number of Simulations");
					System.exit(1);
				}
				while ((line = buffReader.readLine()) != null){
					Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
					flyable.add(flyable);
				}
				for (Flyable flyable : flyables) {
					flyable.registerTower(WeatherTower);
				}
				for (int i = 0; i < simulation; i++) {
					weatherTower.changeWeather();
				}
			}
		} catch (FileNotFoundExeption e) {
			System.out.println("File " + args[0] + " not found.");
		} catch (IOException e) {
			System.out.println("There was an error reading file " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Please specify simulation file");
		}
	}
}