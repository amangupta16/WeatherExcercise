
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

public class WeatherTest {

	
	@Test
	public void getCorrectTemperature() throws MalformedURLException, IOException
	{
		WeatherExcercise weatherObject = new WeatherExcercise();
		String data = weatherObject.getTemperature("chicago");
		String cityName = data.substring(data.indexOf(',')+1, data.length());
		assertEquals("chicago",cityName.toLowerCase());
	}
}
