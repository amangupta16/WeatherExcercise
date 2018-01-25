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
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        System.out.println("Where are you?");
        String cityName = sc.nextLine();
        WeatherExcercise we = new WeatherExcercise();
        we.getTemperature(cityName);

	}
	
	public void getTemperature(String cityName) throws MalformedURLException, IOException{
        //returnTemperature
		String path = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName;
		InputStream inpstr = new URL(path).openStream();
		BufferedReader bfrdrdr = new BufferedReader(new InputStreamReader(inpstr, Charset.forName("UTF-8")));
		StringBuilder strbldr = new StringBuilder();
		int len;
		while ((len = bfrdrdr.read()) != -1) {
			strbldr.append((char) len);
		}
    }

}
