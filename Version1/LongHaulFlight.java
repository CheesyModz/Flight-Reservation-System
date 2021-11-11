/**
 * A long haul flight is a flight that travels thousands of kilometers and typically has separate seating areas 
 * 
 * Student id: 501039657
 * @author Gary Huang
 * @version 1.0
 * @since March 20, 2021
 */

public class LongHaulFlight extends Flight
{
	// Define variables
	int numFirstClassPassengers;
	String seatType;
	
	// Possible seat types
	public static final String firstClass = "First Class Seat";
	public static final String economy 		= "Economy Seat";  
	
	/**
	 * Constructor, set the values of the variables to the values given
	 * 
	 * @param flightNum, the flight number
	 * @param airline, the airline of the flight
	 * @param dest, the destination of the flight
	 * @param departure, the departure time
	 * @param flightDuration, the flight duration
	 * @param aircraft, the aircraft
	 */
	public LongHaulFlight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		// use the super() call to initialize all inherited variables
		super(flightNum, airline, dest, departure, flightDuration, aircraft);
		// also initialize the new instance variables 
		this.numFirstClassPassengers = 0;
		this.seatType = "";
	}

	/**
	 * Constructor, set the variables to defaults
	 */
	public LongHaulFlight()
	{
     // super default constructor
	 super();
	 this.numFirstClassPassengers = 0;
	 this.seatType = "";
	}
	
	/**
	 * Reserves a seat on a flight. Essentially just increases the number of (economy) passengers
	 * 
	 * @return true if reserve seat is successful otherwise false
	 */
	public boolean reserveSeat()
	{
		// override the inherited reserveSeat method and call the reserveSeat method below with an economy seatType
		// use the constants defined at the top
		return reserveSeat(economy);
	}

	/**
	 * Reserves a seat on a flight. Essentially just increases the number of passengers, depending on seat type (economy or first class)
	 * 
	 * @param seatType, the seatTtype of the passenger
	 * @return true if reserve seat is successful otherwise false
	 */
	public boolean reserveSeat(String seatType)
	{
		// if seat type is economy 
		//			call the superclass method reserveSeat() and return the result
		// else if the seat type is first class then 
		// 			check to see if there are more first class seats available (use the aircraft method to get the max first class seats
		// 			of this airplane
		//    	if there is a seat available, increment first class passenger count (see instance variable at the top of the class)
		//    	return true;
		// else return false
		if (seatType.equals("Economy Seat")) return super.reserveSeat();
		else if (seatType.equals("First Class Seat")){
			// ** NOTE **  check
			if (this.numFirstClassPassengers!= aircraft.getNumFirstClassSeats()){
				this.numFirstClassPassengers++;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Cancel an economy seat
	 */
	public void cancelSeat()
	{
	  // override the inherited cancelSeat method and call the cancelSeat method below with an economy seatType
		// use the constants defined at the top
		cancelSeat(economy);
	}
	
	/**
	 * Cancel a the given seat type
	 * 
	 * @param seatType, the seat type of the passenger
	 */
	public void cancelSeat(String seatType)
	{
		// if seat type is first class and first class passenger count is > 0
		//  decrement first class passengers
		// else
		// decrement inherited (economy) passenger count
		if (seatType.equals("First Class Seat") && this.numFirstClassPassengers > 0){
			this.numFirstClassPassengers--;
		}else{
			super.passengers--;
		}
	}

	/**
	 * return the total passenger count of economy passengers *and* first class passengers
	 * use instance variable at top and inherited method that returns economy passenger count
	 * 
	 * @return, the total amount of passengers
	 */
	public int getPassengerCount()
	{
		// return sum of firstclass passengers and economy passengers
		return this.passengers + this.numFirstClassPassengers;
	}

	/**
	 * Return a string of info
	 * 
	 * @return, a string of info
	 */
	public String toString(){
		// return super tostring plus longhaul
		return super.toString() + " LongHaul";
	}
}//ends class
