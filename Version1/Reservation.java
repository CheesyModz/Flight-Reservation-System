/**
 * A simple class to model an electronic airline flight reservation
 * 
 * This class has been done for you
 * 
 * Student id: 501039657
 * @author Gary Huang
 * @version 1.0
 * @since March 20, 2021
 */
public class Reservation
{
	// Initialize variables
	String flightNum;
	String flightInfo;
	boolean firstClass;
	
	/**
	 * Constructor, set the values to the given values
	 * 
	 * @param flightNum, the flight number 
	 * @param info, the information about the flight
	 */
	public Reservation(String flightNum, String info)
	{
		// intialize the variables with the given parameters
		this.flightNum = flightNum;
		this.flightInfo = info;
		this.firstClass = false;
	}
	
	/**
	 * Checks if first class
	 * 
	 * @return true if first class otherwise false
	 */
	public boolean isFirstClass()
	{
		// return first class, true or false
		return firstClass;
	}

	/**
	 * Setter method, set firstclass to be true
	 */
	public void setFirstClass()
	{
		// set first class to be true
		this.firstClass = true;
	}

	/**
	 * Getter method, returns the flight number
	 * 
	 * @return flight number
	 */
	public String getFlightNum()
	{
		// return the string value of flight number
		return flightNum;
	}
	
	/**
	 * Geter method return the flight info
	 * 
	 * @return the flight info
	 */
	public String getFlightInfo()
	{
		// returns the value of the flight info
		return flightInfo;
	}

	/**
	 * Setter method, set flight info to give string value
	 * 
	 * @param flightInfo, the information about the flight
	 */
	public void setFlightInfo(String flightInfo)
	{
		// set flight info to the given value
		this.flightInfo = flightInfo;
	}

	/**
	 * print the flight information
	 */
	public void print()
	{
		// print
		System.out.println(flightInfo);
	}
}//ends class
