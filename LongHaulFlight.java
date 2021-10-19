/**
 * A Long Haul Flight is a flight that travels a long distance and has two types of seats (First Class and Economy)
 * it extends to flight
 * 
 * @author Gary Huang
 * @version 1.0
 * @since April 14, 2021
 */
public class LongHaulFlight extends Flight
{
	// create first class passengers variable
	int firstClassPassengers;
		
	/**
	 * Constructor
	 * @param flightNum, the flight number
	 * @param airline, the flight's airline
	 * @param dest, the destignation
	 * @param departure, the departure
	 * @param flightDuration, the duration of the flight
	 * @param aircraft, the aircraft of the plane
	 */
	public LongHaulFlight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		// call super method with the following values
		super(flightNum, airline, dest, departure, flightDuration, aircraft);
		// set flight type to longhaul
		flightType = FlightType.LONGHAUL;
	}

	/**
	 * Constructor
	 */
	public LongHaulFlight()
	{
		// intialize first class passengers to be zero
		firstClassPassengers = 0;
		// set flight type to longhaul
		flightType = Flight.FlightType.LONGHAUL;
	}
	
	/**
	 * assign seat 
	 * @param p, the passenger object
	 */
	public void assignSeat(Passenger p)
	{
		// set seat to a random seat in aircraft
		int seat = random.nextInt(aircraft.getNumFirstClassSeats());
		// set seat to be first class seat
		p.setSeat("FCL"+ seat);
	}
	
	/**
	 * reserve a seat on the flight
	 * @param name, the passenger's name
	 * @param passport, the passenger's passport
	 * @param seatType, the passenger's seat type
	 * @return if successful
	 */
	public boolean reserveSeat(String name, String passport, String seatType)
	{
		// if seat type is first class seat
		if (seatType.equalsIgnoreCase("FCL"))
		{
			// if first class passengers is greater than aircraft first class seats
			if (firstClassPassengers >= aircraft.getNumFirstClassSeats())
			{
				// return false
				return false;
			}
			// create a passenger object
			Passenger p = new Passenger(name, passport, "", seatType);
			
			// if passenger found in manifest
			if (manifest.indexOf(p) >=  0)
			{
				// return false
				return false;
			}
			// call assign seat method
			assignSeat(p);
			// add passenger to manifest
			manifest.add(p);
			// increase passenger count by 1
			firstClassPassengers++;
			// return true
			return true;
		// else
		}else{
			// create an economy passenger
			Passenger p = new Passenger(name, passport, "", seatType);
			// try
			try{
				// call flights reservate seat
				super.reserveSeat(p, "");
				// return true
				return true;
			// catch flight full exception
			}catch(FlightFullException e){
				// print and return false
				System.out.println(e.toString());
				return false;	
			// catch seat not found exception
			}catch(SeatNotFoundException e){
				// print and return false
				System.out.println(e.toString());
				return false;	
			// catch seat is taken exception
			}catch(SeatOccupiedException e){
				// print and return false
				System.out.println(e.toString());
				return false;	
			// catch duplicate passenger exception
			}catch(DuplicatePassengerException e){
				// print and return false
				System.out.println(e.toString());
				return false;	
			}
		}
	}
	
	/**
	 * cancel a seaet on the flight
	 * @param name, the passenger's name
	 * @param passport, the passenger's passport
	 * @param seatType, the seat type of passenger
	 * @return
	 */
	public boolean cancelSeat(String name, String passport, String seatType)
	{
		//if seat type is first class
		if (seatType.equalsIgnoreCase("FCL"))
		{
			// create a new passenger object
			Passenger p = new Passenger(name, passport);
			// if passenger is not found
			if (manifest.indexOf(p) == -1) 
			{
				// return false
				return false;
			}
			// remove passenger from manifest
			manifest.remove(p);
			// if first class passengers is greater than zero
			// decrease passengers count by 1
			if (firstClassPassengers > 0)	firstClassPassengers--;
			// return true
			return true;
		// else
		}else{
			// create a new passenger object
			Passenger p = new Passenger(name, passport, "", seatType);
			// try
			try{
				// call super's cancel seat method
				super.cancelSeat(p);
				// return true
				return true;
			// catch passenger not in manifest exception
			} catch(PassengerNotInManifestException e){
				// print and return false
				System.out.println(e.toString());
				return false;
			}
		}
	}
	
	/**
	 * Getter Method, returns total number of passengers
	 * @return total passengers
	 */
	public int getPassengerCount()
	{
		// return sum of economy passengers and first class passengers
		return getNumPassengers() +  firstClassPassengers;
	}
	
	/**
	 * Checks if seat is available
	 * @param seatType, returns the seat type of the passenger
	 * @return if seat is available
	 */
	public boolean seatsAvailable(String seatType)
	{
		// if seat type is first class seat
		if (seatType.equals("FCL"))
			// return true
			return firstClassPassengers < aircraft.getNumFirstClassSeats();
		// else
		else
			// return super's seat available method
			return super.seatsAvailable(seatType);
	}

	@Override
	/**
	 * Getter Method, returns the flight type
	 * @return Flight type
	 */
	public FlightType getFlightType(){
		// return flight type
		return flightType;
	}
	
	/**
	 * Prints information
	 * @return flight information plus longhaul
	 */
	public String toString()
	{
		// return string
		 return super.toString() + "\t LongHaul";
	}
}//ends class
