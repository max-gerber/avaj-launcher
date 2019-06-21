import weather;

public class WeatherTower extends Tower{
	public String	getWeather(Coordinates coordinates) {
		return(WeatherProvider.getCurrentWeather(coordinates));
	}
	void			changeWeather(){
		super.conditionsChanged();
	}
}