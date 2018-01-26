import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.MalformedURLException;
import java.io.IOException;
/**
 * 
 */

/**
 * @author amangupta
 *
 */
public class WeatherExcercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws MalformedURLException, IOException{
		// TODO Auto-generated method stub
		
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Where are you?" + "\n");
			String cityName = sc.nextLine();
			WeatherExcercise weatherObject = new WeatherExcercise();
			String data = weatherObject.getTemperature(cityName);
			String temperature = data.substring(0, data.indexOf(','));
			System.out.println(temperature);
		}
		catch (IOException e) {
            e.printStackTrace();
		}

	}
	
	public String getTemperature(String cityName) throws MalformedURLException, IOException{
        //returnTemperature
		
		String path = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=imperial&APPID=b083187d77e0904a1926547855fcfa57";
		InputStream inputStream = new URL(path).openStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		StringBuilder temperatureData = new StringBuilder();
		String[] temperatureArray = new String[2];
		int len;
		while ((len = bufferedReader.read()) != -1) {
			temperatureData.append((char) len);
		}
		String str = "\"main\":{\"temp\":";
		int start = temperatureData.toString().indexOf(str) + 15;
		String temp = temperatureData.toString().substring(start, temperatureData.toString().indexOf(',', start));
		StringBuilder data = new StringBuilder();
		data.append(temp);
		data.append(',');
		data.append(cityName);
		
		return data.toString();
    }

}
