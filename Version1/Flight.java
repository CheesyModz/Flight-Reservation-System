/** 
 *  Class to model an airline flight. In this simple system, all flights originate from Toronto
 *  
 *  This class models a simple flight that has only economy seats
 * 
 * Student id: 501039657
 * @author Gary Huang
 * @version 1.0 
 * @since March 20, 2021
 * 
 */
import java.util.ArrayList;

 public class Flight
{
	// enum that contains delayed, ontime, arrived, and inflight statuses
	public enum Status {DELAYED, ONTIME, ARRIVED, INFLIGHT};

	// Initialize variables as strings
	String flightNum;
	String airline;
	String origin, dest;
	String departureTime;
	// Initialize status as the enum Status
	Status status; // see enum Status above. google this to see how to use it
	// Initialize flight duration as a integer
	int flightDuration;
	// Initialize aircraft as Aircraft object
	Aircraft aircraft;
	// Initialize a protected integer value passenger
	protected int passengers; // count of (economy) passengers on this flight - initially 0
	// Seat number of the passenger
	int seatNumber;
	
	// List of passengers
	ArrayList<Passenger> myPassengers = new ArrayList<Passenger>();

	/**
	 * Constructor, set all the variables to empty string or 0, or new object, or status ontime
	 */
	public Flight()
	{
		// write code to initialize instance variables to default values
		this.flightNum = "";
		this.airline = "";
		this.dest = "";
		this.origin = "";
		this.departureTime = "";
		this.flightDuration = 0;
		this.aircraft = new Aircraft(0, "");
		this.passengers = 0;
		this.status = Status.ONTIME;
		this.seatNumber = 0;
	}
	
	/**
	 * Constructor, set the variables to the values given in the parameters
	 * 
	 * @param flightNum, the flight code
	 * @param airline, the airline of the flight
	 * @param dest, the destination of the flight
	 * @param departure, the departure of the flight
	 * @param flightDuration, the time of the flight
	 * @param aircraft, the type of aircraft the plane is
	 */
	public Flight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		// Initialize the following values to the values given in parameters
		this.flightNum = flightNum;
		this.airline = airline;
		this.dest = dest;
		this.origin = "Toronto";
		this.departureTime = departure;
		this.flightDuration = flightDuration;
		this.aircraft = aircraft;
		this.passengers = 0;
		this.status = Status.ONTIME;
		this.seatNumber = 0;
	}
	
	/**
	 * Getter method, return the flight number
	 * 
	 * @return the flight number
	 */
	public String getFlightNum()
	{
		// returns the string of the flight number
		return flightNum;
	}

	/**
	 * Setter method, sets the value of flight number to given flight number
	 * 
	 * @param flightNum, the flight code
	 */
	public void setFlightNum(String flightNum)
	{
		// sets the value of flightNum to given value
		this.flightNum = flightNum;
	}

	/**
	 * Getter method that returns the airline
	 * 
	 * @return airline
	 */
	public String getAirline()
	{
		// returns the string value of airline
		return airline;
	}

	/**
	 * Setter method that sets the airline value to the given value
	 * 
	 * @param airline
	 */
	public void setAirline(String airline)
	{
		// sets the value of airline to given airline
		this.airline = airline;
	}

	/**
	 * Getter method that returns the origin location
	 * 
	 * @return the flight's starting location
	 */
	public String getOrigin()
	{
		// return the string value of origin
		return origin;
	}

	/**
	 * Setter method that sets the value of origin to the given value
	 * 
	 * @param origin, the starting location of the flight
	 */
	public void setOrigin(String origin)
	{
		// set the value of origin to the given string value
		this.origin = origin;
	}

	/**
	 * Getter method that returns the destination of the flight
	 * 
	 * @return the destination
	 */
	public String getDest()
	{
		// return the string value of dest
		return dest;
	}

	/**
	 * Setter method that sets destination to the given destination
	 * 
	 * @param dest, the destination of the flight
	 */
	public void setDest(String dest)
	{
		// sets the value of destination to the given string value of destination
		this.dest = dest;
	}

	/**
	 * Getter method that returns when the flight will fly
	 * 
	 * @return the departure time
	 */
	public String getDepartureTime()
	{
		// return the string value of departure time
		return departureTime;
	}

	/**
	 * Setter method that sets the departure time to the given departure time
	 * 
	 * @param departureTime, the time when the flight is about to fly
	 */
	public void setDepartureTime(String departureTime)
	{
		// set the value of departure time to the given string value of departure time
		this.departureTime = departureTime;
	}
	
	/**
	 * Getter method that returns the status of the flight
	 * 
	 * @return the status of the flight
	 */
	public Status getStatus()
	{
		// returns the status of the flight
		return status;
	}

	/**
	 * Setter method that sets the statsu of the flight
	 * 
	 * @param status, the status of the flight
	 */
	public void setStatus(Status status)
	{
		// sets the value of status to the given status value
		this.status = status;
	}

	/**
	 * Getter method to get the flight duration
	 * 
	 * @return the flight duration
	 */
	public int getFlightDuration()
	{
		// returns the integer value of the flight duration
		return flightDuration;
	}

	/**
	 * Setter method that sets the value of flight duration to the given value
	 * 
	 * @param dur, the duration of the flight
	 */
	public void setFlightDuration(int dur)
	{
		// sets the value of flightDuration to the given integer value
		this.flightDuration = dur;
	}
	
	/**
	 * Getter method that returns the amount of passengers
	 * 
	 * @return, the amount of passengers in the flight
	 */
	public int getPassengers()
	{
		// returns the integer value of the passnegers on the flight
		return passengers;
	}

	/**
	 * Setter method that sets the value of passengers to the given value of passengers
	 * 
	 * @param passengers, the amount of passengers in the flight
	 */
	public void setPassengers(int passengers)
	{
		// sets the value of passengers to the given integer value
		this.passengers = passengers;
	}
	
	/**
	 * Returns if there is seats available on the flight
	 * 
	 * Check to see if there is room on this flight - compare current passenger count
	 * with aircraft max capacity of economy seats
	 *
	 * @return, true if theres space, false if theres no space
	 */
	public boolean seatsAvailable()
	{
		// checks if the passengers amount is equal to the aircraft total seats
		// if equal then return false otherwise true
		if (this.getPassengers() != aircraft.getTotalSeats()) return true;
		return false;
	}
	
	/**
	 * Returns the amount of passengers by one
	 * 
	 * Cancel a seat - essentially reduce the passenger count by 1. Make sure the count does not
	 * fall below 0 (see instance variable passenger)
	 */
	public void cancelSeat()
	{
		//if the passengers are not equal to zero, then subtract one from the passenger count
		if (this.passengers != 0) this.passengers--;
	}
	
	/**
	 * Reserve a seat on the flight, increasing the passenger count by 1 if theres space
	 * 
	 * reserve a seat on this flight - essentially increases the passenger count by 1 only if there is room for more
	 * economy passengers on the aircraft used for this flight (see instance variables above)
	 * 
	 * @return true if theres space otherwise false
	 */
	public boolean reserveSeat()
	{
		// check if theres spacee for passengers on flight, if so increase passenger count by 1 and return true
		// otherwise return false
		if (this.getPassengers() != aircraft.getNumSeats()){
			this.passengers++; 
			return true;
		}
		return false;
	}
	
	/**
	 * Returns all the information regarding the flight in one string
	 * 
	 * @return the string info the flight
	 */
	public String toString()
	{
		// returns the value of airline, flight number, destination, departure time, flight duration, and the status of the flight
		 return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status;
		
	}

	/**
	 * Checks to see if theres any issues with the passenger and if theres space, if so then add passenger to mypassenger arraylist 
	 * 
	 * @param pass, receieve reference to passenger object
	 * @return true if successful otherwise false
	 */
	public boolean passengerSeat(Passenger pass){
		// intialize equals variable with value false
		boolean equals = false;
		// for loop through my passengers to check name and passport number are equal, set equals true and break if so
		for (int i = 0; i < myPassengers.size(); i++){
			if (myPassengers.get(i).equals(pass)){
				equals = true;
				break;
			}
		}
		// if equals is false and there is space in the aircraft, add one to passenger count and print flight number, name, passport number, and seat number
		if (!equals && this.getPassengers() != aircraft.getNumSeats()){
			this.passengers++;
			myPassengers.add(pass);
			System.out.println(pass.toString());
			// return true
			return true;
		// else if there is no space in the aircraft print its full
		}else if (this.getPassengers() == aircraft.getNumSeats()){
			System.out.println(pass.getFlightNum() + " is full.");
		// otherwise print the name and passport is already added
		}else{
			System.out.println("Error! Same name and passport number has already been added.");
		}
		// return false
		return false;
	}

	/**
	 * gets a seat number parameter and checks if its taken
	 * 
	 * @param seatNum, the randomly assigned seat number
	 * @return false if seat taken otherwise true
	 */
	public boolean passengerSeatAvailable(int seatNum){
		// for loop through my passengers and check if seat number is taken, if so return false
		// otherwise initalize this seat number and return true
		for (Passenger i : myPassengers){
			if (i.getPassengerSeat() == seatNum){
				return false;
			}
		}
		this.setPassengersSeat(seatNum);
		return true;
	}

	/**
	 * Search through my passengers array list and if name and passport number is found then remove from arraylist
	 * 
	 * @param name, the name of the passenger
	 * @param passortNumber, the passport number of the passenger
	 * @return true if cancelled, otherwise false
	 */
	public boolean cancelPassengerSeat(String name, String passportNumber){
		// for loop through my passengers and if name and passport number are equal, remove from array list, minus one from passenger count, and return true
		for (Passenger i : myPassengers){
			if (i.getName().equalsIgnoreCase(name) && i.getPassportNumber().equalsIgnoreCase(passportNumber)){
				myPassengers.remove(i);
				this.passengers--;
				return true;
			}
		}
		// return false
		return false;
	}

	/**
	 * Setter method, set the seat number to the given integer value
	 * 
	 * @param seatNum, the passengers seat number
	 */
	public void setPassengersSeat(int seatNum){
		// seat seat number to the given value
		this.seatNumber = seatNum;
	}

	/**
	 * Getter method, return the seat number of the passenger
	 * 
	 * @return the seat number 
	 */
	public int getPassengerSeat(){
		// return seat number
		return this.seatNumber;
	}

	/**
	 * Print all passengers
	 */
	public void printPassengers(){
		// loop through my passengers and print each one's information
		for (Passenger i : myPassengers){
			System.out.println(i.toString());
		}
	}

}//ends class
