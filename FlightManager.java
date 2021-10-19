// import file not found exception, file reader, array list, hash map, map, random, scanner, and treemap
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * This class is the flight manager
 * 
 * @author Gary Huang
 * @version 1.0
 * @since April 14, 2021
 */
public class FlightManager
{
  // create a treemap of flights
  TreeMap<String, Flight> flights = new TreeMap<String, Flight>();
  // create an array of cities
  String[] cities = {"Dallas", "New York", "London", "Paris", "Tokyo"};
  // define variables
  final int DALLAS = 0;  final int NEWYORK = 1;  final int LONDON = 2;  final int PARIS = 3; final int TOKYO = 4;
  // create map of flight times
  Map <String, Integer> flightTimes = new HashMap <String, Integer>();
  // create an array list of airplanes
  ArrayList<Aircraft> airplanes = new ArrayList<Aircraft>();  
  // create random object
  Random random = new Random();
  
  /**
   * Constructor
   * @throws FileNotFoundException, file not found exception
   */
  public FlightManager() throws FileNotFoundException
  {
	// put these flight times into the map
	flightTimes.put("Dallas", 3);
	flightTimes.put("New York", 1);
	flightTimes.put("London", 7);
	flightTimes.put("Paris", 8);
	flightTimes.put("Tokyo", 16);
	// Create some aircraft types with max seat capacities
	airplanes.add(new Aircraft(84, "Boeing 737"));
	airplanes.add(new Aircraft(44,"Airbus 320"));
	airplanes.add(new Aircraft(36, "Dash-8 100"));
	airplanes.add(new Aircraft(4, "Bombardier 5000"));
	airplanes.add(new Aircraft(100, 8, "Boeing 747"));
	// try to do the following code
	try{
		// read the scanner file 
		Scanner in = new Scanner(new FileReader("flights.txt"));
		// while there is a next line
		while (in.hasNextLine()){
			// set word to be the next word
			String word = in.next();
			// replace '_' with space
			word = word.replace('_', ' ');
			// split the word into a list
			String []words = word.split(" ");
			// set airline to be the first and second word in the list
			String airLine = words[0] + " " + words[1];
			// generate a flight number and set it to flight num
			String flightNum = generateFlightNumber(airLine);
			// set dest to be the next word
			String dest = in.next();
			// if dest contains '_' then replace it with a space
			if (dest.contains("_")){
				dest = dest.replace('_', ' ');
			}
			// set duration to be the next word
			String dur = in.next();
			// set seat to be the next word
			String seat = in.next();
			// initialize variables
			int index = 0;
			int difference = 100;
			// loop through each airplace to check which one is more valid for the number of seats
			for (int i = 0; i < airplanes.size(); i ++){
				// if seats are less than aircraft seats then check if the difference is less than difference
				if (Integer.parseInt(seat) <= airplanes.get(i).getTotalSeats()){
					if (difference >= (airplanes.get(i).getTotalSeats() - Integer.parseInt(seat))){
						// set difference to be the difference
						difference = (airplanes.get(i).getTotalSeats() - Integer.parseInt(seat));
						// set index to be i
						index = i;
					}
				}
			}
			// create a flight object with the values given
			Flight flight = new Flight(flightNum, airLine, dest, dur, flightTimes.get(dest), airplanes.get(index));
			// put the flight object into the flights treemap
			flights.put(flightNum, flight);
		}
	// catch file no found exception 
	}catch(FileNotFoundException e){
		// throw file not found exception
		throw new FileNotFoundException("File Not Found");
	}
  }
  
  /**
   * Generate a flight number
   * @param airline, the airline of the plane
   * @return the generated flight number
   */
  private String generateFlightNumber(String airline)
  {
	// create scanner object
  	Scanner scanner = new Scanner(airline);
	// get the next 2 words and set to variables
  	String word1 = scanner.next();
  	String word2 = scanner.next();
	//set the first letter of each word to vairables
  	String letter1 = word1.substring(0, 1);
  	String letter2 = word2.substring(0, 1);
	// set letters to uppcase
  	letter1.toUpperCase(); 
	letter2.toUpperCase();
	// close scanner object
	scanner.close();
  	
  	// Generate random number between 101 and 300
  	int flight = random.nextInt(200) + 101;
	// add all the piece together and return
  	String flightNum = letter1 + letter2 + flight;
   	return flightNum;
  }

  /**
   * print all flights
   */
  public void printAllFlights()
  {
	// loop through each flights in the treemap and print flights' information
  	for (Flight f : flights.values())
  		System.out.println(f.toString());
  }

  /**
   * print seat map seats
   * @param flightNum, the flight number of the flight
   */
  public void printSeatMap(String flightNum){
	// loop for each flight in flights
	for (Flight f : flights.values()){
		// if flight number is equal to the given flight number
		if (f.getFlightNum().equals(flightNum)){
			// call print seats
			f.printSeats();
		}
	}
  }

  /**
   * prints manifest
   * @param flightNum, the flight number of flight
   */
  public void printManifest(String flightNum){
	// loop through each flight in the tree map
	for (Flight f : flights.values()){
		// if flight number is equal to the given flight number 
		if (f.getFlightNum().equals(flightNum)){
			// for loop each manifest and print
			for (int i = 0; i < f.manifest.size(); i++){
				System.out.println(f.manifest.get(i));
			}
		}	
	}
  }
  
  /**
   * checjs if seat is available
   * @param flightNum, the number of the flight
   * @param seat, the seat wanted
   * @return if seat is available
   */
  public boolean seatsAvailable(String flightNum, String seat)
  {
	// set found to false
	boolean found = false;
	// loop through each flight
	for (String i : flights.keySet()){
		// if flight number equals the given flight number
		if (flights.get(i).getFlightNum().equals(flightNum)){
			// set found to be true and break
			found = true;
			break;
		}
	}
	// if found is false then print flight number not found
    if (!found)
  	{
		System.out.println("Flight " + flightNum + " Not Found");
  	}
	// else return call the flight number's seats available method
   	return flights.get(flightNum).seatsAvailable(seat);
  }
  
  /**
   * Reserves a seaet on the flight if valid
   * @param flightNum, the flight number of the flight
   * @param name, the passenger's name
   * @param passport, the passenger's passport
   * @param seat, the seat wanted
   * @return reservation object
   * @throws FlightFullException, flight is full
   * @throws SeatNotFoundException, seat is not found
   * @throws SeatOccupiedException, seat is taken
   * @throws DuplicatePassengerException, duplicate passenger
   */
  public Reservation reserveSeatOnFlight(String flightNum, String name, String passport, String seat) throws FlightFullException, SeatNotFoundException, SeatOccupiedException, DuplicatePassengerException
  {
	// set found to be false
	boolean found = false;
	// loop through each flight number
	for (String i : flights.keySet()){
		// if flight number is equal to the given flight number
		if (flights.get(i).getFlightNum().equals(flightNum)){
			// set found to be true and brkea
			found = true;
			break;
		}
	}
	// if found is false
  	if (!found)
  	{
		// print flight number is not found and return null
  		System.out.println(flightNum + " Not Found");
  		return null;
  	}
	// create flight object ot the treemap's flight
  	Flight flight = flights.get(flightNum);
	// create a passenger object
  	Passenger p = new Passenger(name, passport, seat, "");
	// reserve a seat on the flight
	flight.reserveSeat(p, seat);
	// return reservation object
	return new Reservation(flightNum, flight.toString(), name, passport, seat, "");
  }
  
  /**
   * Cancel a reservation
   * @param res, reservation object
   * @throws PassengerNotInManifestException, passenger is not in manifest
   */
  public void cancelReservation(Reservation res) throws PassengerNotInManifestException
  {
	// set found to be false
	boolean found = false;
	// loop through each flight number
	for (String i : flights.keySet()){
		// if flight number is equal to the reservation flight number
		if (flights.get(i).getFlightNum().equals(res.getFlightNum())){
			// set found to be true
			found = true;
		}
	}
	// if found is false
  	if (!found)
    {
		// print flight number is not found
		System.out.println("Flight " + res.flightNum + " Not Found");
	}
	// otherwise create a flight object
  	Flight flight = flights.get(res.getFlightNum());
	// creates a passenger object
	Passenger p = new Passenger(res.name, res.passport, res.seat, res.seatType);
	// cancel the seat
	flight.cancelSeat(p);
  }
}//ends class
