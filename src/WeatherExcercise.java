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
			System.out.println("Where are you?");
			String cityName = sc.nextLine();
			WeatherExcercise weatherObject = new WeatherExcercise();
			String data = weatherObject.getTemperature(cityName);
			String temperature = data.substring(0, data.indexOf(','));
			System.out.println(cityName + " weather:");
			System.out.println(temperature + " degrees Fahrenheit");
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
		int len;
		while ((len = bufferedReader.read()) != -1) {
			temperatureData.append((char) len);
		}
		String string1 = "\"main\":{\"temp\":";
		int start1 = temperatureData.toString().indexOf(string1) + 15;
		String temp = temperatureData.toString().substring(start1, temperatureData.toString().indexOf(',', start1));
		String string2 = "\"name\":";
		int start2 = temperatureData.toString().indexOf(string2) + 7;
		String cityFromJson = temperatureData.toString().substring(start2, temperatureData.toString().indexOf(',', start2));
		String cityFromJsonClean = cityFromJson.substring(1, cityFromJson.length()-1);
		StringBuilder data = new StringBuilder();
		data.append(temp);
		data.append(',');
		data.append(cityFromJsonClean);
		return data.toString();
    }

}
