import java.util.Scanner;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        System.out.println("Where are you?");
        String cityName = sc.nextLine();
        WeatherExcercise we = new WeatherExcercise();
        we.getTemperature(cityName);

	}
	
	public void getTemperature(String cityName){
        //returnTemperature
		System.out.println(cityName + " Temperature:");
    }

}
