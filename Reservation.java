/**
 * Reservation object contains information about the passenger's reservation
 * 
 * @author Gary Huang
 * @version 1.0
 * @since April 14, 2021
 */
public class Reservation
{
	// initialize variables
	String flightNum;
	String flightInfo;
	String name;
	String passport;
	String seat;
	String seatType;
	boolean firstClass;
	
	/**
	 * Constructor
	 * @param flightNum, the flight number
	 * @param info, the information about the flight
	 */
	public Reservation(String flightNum, String info)
	{
		// intialize variables to the given values
		this.flightNum = flightNum;
		this.flightInfo = info;
	}

	/**
	 * Constructor
	 * @param flightNum, the flight number
	 * @param name, the passenger's name
	 * @param passport, the passenger's passport
	 */
	public Reservation(String flightNum, String name, String passport)
	{
		// initialize variables to the given values
		this.flightNum = flightNum;
		this.name = name;
		this.passport = passport;
	}
	
	/**
	 * Constructor
	 * @param flightNum, the flight number
	 * @param info, the flight's information
	 * @param name, the passenger's name
	 * @param passport, the passenger's passport
	 * @param seat, the seat of passenger
	 * @param seatType, the seat type
	 */
	public Reservation(String flightNum, String info, String name, String passport, String seat, String seatType)
	{
		// initialize variables to the given values
		this.flightNum = flightNum;
		this.flightInfo = info;
		this.name = name;
		this.passport = passport;
		this.seat = seat;
		this.seatType = seatType;
	}
	
	/**
	 * Getter Method, returns the flight number
	 * @return flight number
	 */
	public String getFlightNum()
	{
		// return flight number
		return flightNum;
	}
	
	/**
	 * Getter Method, returns flight information
	 * @return flight information
	 */
	public String getFlightInfo()
	{
		// return flight information
		return flightInfo;
	}

	/**
	 * Setter Method, set the flight information
	 * @param flightInfo, the flights information
	 */
	public void setFlightInfo(String flightInfo)
	{
		// set flight information to the given value
		this.flightInfo = flightInfo;
	}
	
	/**
	 * Checks if flight number, name, and passport are equal
	 * @param other, other reservation object
	 * @return if they are equal
	 */
	public boolean equals(Object other)
	{
		// cast other to be reservation object
		Reservation otherRes = (Reservation) other;
		// return if they are equal by flight number, name, and passport
		return flightNum.equals(otherRes.flightNum) &&  name.equals(otherRes.name) && passport.equals(otherRes.passport); 
	}

	/**
	 * print reservation informatipn
	 */
	public void print()
	{
		// print flight information, name, and seat
		System.out.println(flightInfo + " " + name + " " + seat);
	}
}//ends class
