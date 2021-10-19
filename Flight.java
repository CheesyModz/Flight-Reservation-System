// import arraylist, random, and treemap
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

/**
 * Flight class contains information about the flight
 * 
 * @author Gary Huang
 * @version 1.0
 * @since April 14, 2021
 */
public class Flight
{
	// create enum of status of the plane
	public enum Status {DELAYED, ONTIME, ARRIVED, INFLIGHT};
	// create enum of flight type
	public static enum FlightType {SHORTHAUL, MEDIUMHAUL, LONGHAUL};
	// create enum of seat type
	public static enum SeatType {ECONOMY, FIRSTCLASS, BUSINESS};

	// initialize variables
	private String flightNum;
	private String airline;
	private String origin, dest;
	private String departureTime;
	private Status status;
	private int flightDuration;
	protected Aircraft aircraft;
	protected int numPassengers;
	protected FlightType flightType;
	protected ArrayList<Passenger> manifest;
	protected TreeMap<String, Passenger> seatMap;
	// create a proteected random object
	protected Random random = new Random();
	/**
	 * constructor, set all variables to default
	 */
	public Flight()
	{
		// Set the following variables to default valuies
		this.flightNum = "";
		this.airline = "";
		this.dest = "";
		this.origin = "Toronto";
		this.departureTime = "";
		this.flightDuration = 0;
		this.aircraft = null;
		numPassengers = 0;
		status = Status.ONTIME;
		flightType = FlightType.MEDIUMHAUL;
		manifest = new ArrayList<Passenger>();
		seatMap = new TreeMap<String, Passenger>();
	}
	
	/**
	 * Constructor, set the flight number to the given value
	 * @param flightNum, the flight number of the airplane
	 */
	public Flight(String flightNum)
	{
		// set flight number to the given value
		this.flightNum = flightNum;
	}
	
	/**
	 * Constructor, set the following variables to the given values
	 * 
	 * @param flightNum, the flight number of the plane
	 * @param airline, the type of airline
	 * @param dest, the designation
	 * @param departure, the departure
	 * @param flightDuration, the flight duration
	 * @param aircraft, the aircraft object
	 */
	public Flight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		// set all the varialbes to the given values
		this.flightNum = flightNum;
		this.airline = airline;
		this.dest = dest;
		this.origin = "Toronto";
		this.departureTime = departure;
		this.flightDuration = flightDuration;
		this.aircraft = aircraft;
		numPassengers = 0;
		status = Status.ONTIME;
		flightType = FlightType.MEDIUMHAUL;
		manifest = new ArrayList<Passenger>();
		seatMap = new TreeMap<String, Passenger>();
	}

	/**
	 * Getter Method, returns the flight type of the flight
	 * @return flightType
	 */
	public FlightType getFlightType()
	{
		// return flight type
		return flightType;
	}
	
	/**
	 * Getter Method, returns the number of the flight
	 * @return flightNum, the number of the flight
	 */
	public String getFlightNum()
	{
		// return flight number
		return flightNum;
	}

	/**
	 * Setter Method, set the flight number to the given string value
	 * @param flightNum, the flight number of the plane
	 */
	public void setFlightNum(String flightNum)
	{
		// set the flight number to the given value
		this.flightNum = flightNum;
	}

	/**
	 * Getter Method, returns the airline of the flight 
	 * @return airline of flight
	 */
	public String getAirline()
	{
		// return airline
		return airline;
	}
	
	/**
	 * Setter Method, set the airline to the given value
	 * @param airline, the airline of the plane
	 */
	public void setAirline(String airline)
	{
		// set airline to given string value
		this.airline = airline;
	}

	/**
	 * Getter Method, returns the origin of the flight
	 * @return origin
	 */
	public String getOrigin()
	{
		// returns origin
		return origin;
	}

	/**
	 * Setter Method, set the origin to the given value
	 * @param origin, the origin of the plane
	 */
	public void setOrigin(String origin)
	{
		// set origin to the given value
		this.origin = origin;
	}

	/**
	 * Getter Method, returns the destignation of the plane
	 * @return dest, the designation of the plane
	 */
	public String getDest()
	{
		// returns destignation
		return dest;
	}

	/**
	 * Setter Method, set the designation of the plane
	 * @param dest, the desigination of the plane
	 */
	public void setDest(String dest)
	{
		// set dest to the given value
		this.dest = dest;
	}

	/**
	 * Getter Method, returns the departure time of the flight
	 * @return the departure time
	 */
	public String getDepartureTime()
	{
		// return departure time
		return departureTime;
	}

	/**
	 * Setter Method, set the departure time to the given value
	 * @param departureTime, the departure time of the flight
	 */
	public void setDepartureTime(String departureTime)
	{
		// set departure time to the given value
		this.departureTime = departureTime;
	}
	
	/**
	 * Getter Method, returns the status of the plane
	 * @return the status of the plane
	 */
	public Status getStatus()
	{
		// return status
		return status;
	}

	/**
	 * Setter Method, set the status of the plane
	 * @param status, the status of the plane
	 */
	public void setStatus(Status status)
	{
		// set status to the given value
		this.status = status;
	}

	/**
	 * Getter Method, returns the flight duration
	 * @return the flight duration
	 */
	public int getFlightDuration()
	{
		// return flight duration
		return flightDuration;
	}

	/**
	 * Setter Method, set the flight duration
	 * @param dur, the duration of the flight
	 */
	public void setFlightDuration(int dur)
	{
		// set flight duration to the given value
		this.flightDuration = dur;
	}
	
	/**
	 * Getter Method, returns the number of passengers
	 * @return number of passengers
	 */
	public int getNumPassengers()
	{
		// return number of passengers
		return numPassengers;
	}

	/**
	 * Setter Method, set the number of passenger
	 * @param numPassengers, the number of passenger
	 */
	public void setNumPassengers(int numPassengers)
	{
		// set number of passengers to the given value
		this.numPassengers = numPassengers;
	}
	
	/**
	 * Assign the passenger to the seat
	 * @param p, the passenger object
	 * @param seat, the seat
	 */
	public void assignSeat(Passenger p, String seat)
	{
		// call set seat method
		p.setSeat(seat);
		// put seat and passenger to the seatMAp
		seatMap.put(seat, p);
	}
	
	/**
	 * Check if the seat is available in the seatLayout in aircraft
	 * @param seat, the seat to be checked
	 * @return true if seat available otherwise false
	 */
	public boolean seatsAvailable(String seat)
	{
		// Nested for loop to loop through each element in the seat Layout
		for (int i = 0; i < 4; i++){
			for (String j : seatMap.keySet()){
				// if the element is equal to seat return false
				if (j.equals(seat)){
					return false;
				}
			}
		}
		// otherwise return true
		return true;
	}
	
	/**
	 * Cancel a seat
	 * @param p, the passenger object
	 * @throws PassengerNotInManifestException, throw an exception if not found
	 */
	public void cancelSeat(Passenger p) throws PassengerNotInManifestException
	{
		// if passenger is not found in manifest
		// throw a PassengerNotInManifestException 
		if (manifest.indexOf(p) == -1) 
		{
			throw new PassengerNotInManifestException("Passenger " + p.getName() + " " + p.getPassport() + " Not Found");
		}
		// remove passenger from manifest
		manifest.remove(p);
		// remove seat from seat map
		seatMap.remove(p.getSeat());
		// if number of passengers is greater than 0
		// decrease the number of passengers by 1
		if (numPassengers > 0) numPassengers--;
	}
	
	/**
	 * Reserve a seat 
	 * @param p, the passenger object
	 * @param seat, the seat wanted
	 * @throws FlightFullException, full is full exception
	 * @throws SeatNotFoundException, seat is not valid exception
	 * @throws SeatOccupiedException, the seat is already taken exception
	 * @throws DuplicatePassengerException, there is a duplication passenger exception
	 */
	public void reserveSeat(Passenger p, String seat) throws FlightFullException, SeatNotFoundException, SeatOccupiedException, DuplicatePassengerException
	{
		// if number of passengers is greater or equal to aircraft's seat throw flight full exception
		if (numPassengers >= aircraft.getNumSeats())
		{
			throw new FlightFullException("Flight " + flightNum + " Full");
		}
		// set found to be false
		boolean found = false;
		// loop through each aircraft seat, if seat is found, set found to be true and break
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < aircraft.getTotalSeats() / 4; j++){
				if (aircraft.seatLayout[i][j].equals(seat)){
					found = true;
					break;
				}				
			}
		}
		// if found is false throw seat not found exception
		if (!found) throw new SeatNotFoundException("Seat " + seat + " Not Found");
		// else if seaet is not available
		else if (!seatsAvailable(seat)) 
		{
			// throw seat is taken
			throw new SeatOccupiedException("Seat " + seat + " already occupied");
		}
		// if passenger is found in manifest, throw duplicate passenger exception
		else if (manifest.indexOf(p) >=  0)
		{
			throw new DuplicatePassengerException("Duplicate Passenger " + p.getName() + " " + p.getPassport()); 
		// otherwise
		}else{
			// call assign seat method
			assignSeat(p, seat);
			// add the passenger to manifest
			manifest.add(p);
			// increase number of passengers by 1
			numPassengers++;
			// put seat and passenger in seat map
			seatMap.put(seat, p);
		}
	}
	
	/**
	 * Check if two flightnumbers are equal
	 * @param other, the other flight object
	 * @return return if equal otherwise false
	 */
	public boolean equals(Object other)
	{
		// case other to be flight
		Flight otherFlight = (Flight) other;
		// return if they are equal
		return this.flightNum.equals(otherFlight.flightNum);
	}

	/**
	 * Print passenger in manifest
	 */
	public void printPassengerManifest(){
		// loop through each passenger in manifest
		for (Passenger i : manifest){
			// print passengers
			System.out.println(i);
		}
	}

	/**
	 * print seats of a flight
	 */
	public void printSeats(){
		// nested for loop to get each element in the seat layout
		for (int i = 0; i < 4; i++){
            for (int j = 0; j < aircraft.getTotalSeats()/4; j++){
				// if seat map contains the aircraft seat
				if (seatMap.containsKey(aircraft.seatLayout[i][j])){
					// print XX
					System.out.print("XX ");
				// else print the seat
				}else{
					System.out.print(aircraft.seatLayout[i][j] + " ");
				}
            }
			// print new line
            System.out.println();
        }
		// print what xx means and + means
		System.out.println("\nXX = Occupied  \n+  = First Class");
	}

	/**
	 * toString method
	 * @return the string information of the flight
	 */
	public String toString()
	{
		// return information about the flight
		 return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status;
	}
}//end of class

/**
 * Flight full exception
 */
final class FlightFullException extends Throwable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 9059833762556989938L;

	/**
	 * calls the super method given message
	 * @param message, the error message
	 */
	public FlightFullException(String message){
		super(message);
	}
}

/**
 * Seat not found exception
 */
final class SeatNotFoundException extends Throwable{

	/**
	 *
	 */
	private static final long serialVersionUID = 255773792284505005L;

	/**
	 * calls the super method given message
	 * @param message, the error message
	 */
	public SeatNotFoundException(String message){
		super(message);
	}
}

/**
 * duplication passenger exception
 */
final class DuplicatePassengerException extends Throwable{
	/**
	 *
	 */
	private static final long serialVersionUID = -3621744809275837677L;

	/**
	 * calls the super method given message
	 * @param message, the error message
	 */	
	public DuplicatePassengerException(String message){
		super(message);
	}
}

/**
 * passenger is not in manifest exception
 */
final class PassengerNotInManifestException extends Throwable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1282022160174084838L;

	/**
	 * calls the super method given message
	 * @param message, the error message
	 */	
	public PassengerNotInManifestException(String message){
		super(message);
	}
}

/**
 * seat is occupied exception
 */
final class SeatOccupiedException extends Throwable{
	/**
	 *
	 */
	private static final long serialVersionUID = 6198558057665365506L;

	/**
	 * calls the super method given message
	 * @param message, the error message
	 */	
	public SeatOccupiedException(String message){
		super(message);
	}
}