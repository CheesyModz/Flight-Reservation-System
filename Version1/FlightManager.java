/**
 * This class creates all the flight and aircraft objects.
 * 
 * Student id: 501039657
 * @author Gary Huang
 * @version 1.0
 * @since March 20, 2021
 */

 //import ArrayList, Collections, Comparator, Random, and Scanner
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * Creates the FlightManager class
 */
public class FlightManager
{
  // Contains list of Flights departing from Toronto in a single day
	ArrayList<Flight> flights = new ArrayList<Flight>();
  // Creates an array of the cities
  String[] cities = 	{"Dallas", "New York", "London", "Paris", "Tokyo"};
  // Initialize the following variables
  final int DALLAS = 0;  final int NEWYORK = 1;  final int LONDON = 2;  final int PARIS = 3; final int TOKYO = 4;
  
  // flight times in hours
  int[] flightTimes = { 3, // Dallas
  											1, // New York
  											7, // London
  											8, // Paris
  											16// Tokyo
  										};
  
  // Contains list of available airplane types and their seat capacity
  ArrayList<Aircraft> airplanes = new ArrayList<Aircraft>();  
  // Initialize errorMsg
  String errorMsg = null; // if a method finds an error (e.g. flight number not found) set this string. See video!
  // Define random object
  Random random = new Random(); // random number generator - google "Java class Random". Use this in generateFlightNumber
  
  /**
   * Constructor, defines all the aircrafts and flight objects
   */
  public FlightManager()
  {
  	// DO NOT ALTER THIS CODE - THE TA'S WILL USE IT TO TEST YOUR PROGRAM
  	// IN ASSIGNMENT 2 YOU WILL BE LOADING THIS INFORMATION FROM A FILE
  
  	// Create some aircraft types with max seat capacities
  	airplanes.add(new Aircraft(85, "Boeing 737"));
  	airplanes.add(new Aircraft(180,"Airbus 320"));
  	airplanes.add(new Aircraft(37, "Dash-8 100"));
  	airplanes.add(new Aircraft(12, "Bombardier 5000"));
  	airplanes.add(new Aircraft(592, 14, "Boeing 747"));
  	
  	// Populate the list of flights with some random test flights
  	String flightNum = generateFlightNumber("United Airlines");
  	Flight flight = new Flight(flightNum, "United Airlines", "Dallas", "1400", flightTimes[DALLAS], airplanes.get(0));
  	flights.add(flight);
  	flight.setStatus(Flight.Status.DELAYED);
  	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "London", "2300", flightTimes[LONDON], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "Paris", "2200", flightTimes[PARIS], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Porter Airlines");
   	flight = new Flight(flightNum, "Porter Airlines", "New York", "1200", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "New York", "0900", flightTimes[NEWYORK], airplanes.get(3));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "New York", "0600", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "Paris", "2330", flightTimes[PARIS], airplanes.get(0));
   	flights.add(flight);
   	
    /*
     * Add this code back in when you are ready to tackle class LongHaulFlight and have implemented its methods
     */
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new LongHaulFlight(flightNum, "Air Canada", "Tokyo", "2200", flightTimes[TOKYO], airplanes.get(4));
   	flights.add(flight);
  }
  
  /**
   * This private helper method generates and returns a flight number string from the airline name parameter
   * For example, if parameter string airline is "Air Canada" the flight number should be "ACxxx" where xxx is 
   * a random 3 digit number between 101 and 300 (Hint: use class Random - see variable random at top of class)
   * you can assume every airline name is always 2 words. 
   * 
   * Generates the flight number of the flight
   * 
   * @param airline, the airline of the aircraft
   * @return the string value of the flight number
   */
  private String generateFlightNumber(String airline)
  {
    // define scanner object with the string airline
    Scanner in = new Scanner(airline);
    // set word1 to the first word and word2 to the second word
    String word1 = in.next();
    String word2 = in.next();
    // generate a random number from 0 to 199 and add 101
    int number = random.nextInt(199) + 101;
    // return the flight number
    return "" + word1.charAt(0) + word2.charAt(0) + String.valueOf(number);
  }

  /**
   * Prints all flights in flights array list (see class Flight toString() method) 
   * This one is done for you!
   */
  public void printAllFlights()
  {
    // for loop for every flight and print each one
  	for (int i = 0; i < flights.size(); i++)
  	{
  		System.out.println(flights.get(i).toString());
  	}
  }
  
  /**
   * Given a flight number (e.g. "UA220"), check to see if there are economy seats available
   * if so return true, if not return false
   * 
   * @param flightNum, the flight code of the flight
   * @return, if there is seats available, true if yes, false if no
   */
  public boolean seatsAvailable(String flightNum)
  {
    // First check for a valid flight number
    // if it is not found, set errorMsg String and return false
    // To determine if the given flightNum is valid, search the flights array list and find 
    // the  Flight object with matching flightNum string
    // Once a Flight object is found, check if seats are available (see class Flight) 
    // if flight is full, set errorMsg to an appropriate message (see video) and return false
    // otherwise return true
    // loop through the flights and check if the flight number given is equal to the flight's flight number
    // if so check if seats available, if so return true, otherwise set error message and return false
    for (int i = 0; i < flights.size(); i++){
      if (flights.get(i).getFlightNum().equalsIgnoreCase(flightNum)){
        if (flights.get(i).seatsAvailable()){
          return true;
        }
        errorMsg = "Flight " + flightNum + " is Full";
        return false;
      }
    }
  return false;
  }
  
  /**
   * Given a flight number string flightNum and a seat type, reserve a seat on a flight
   * If successful, return a Reservation object
   * NOTE: seat types are not used for basic Flight objects (seats are all "Economy Seats")
   * class LongHaulFlight defines two seat types
   * I  suggest you first write this method *without* considering class LongHaulFlight 
   * once that works (test it!!), add the long haul flight code
   * 
   * @param flightNum, the flight number of the flight
   * @param seatType, the seat type
   * @return reference to reservation object
   */
  public Reservation reserveSeatOnFlight(String flightNum, String seatType)
  {
  	// Check for valid flight number by searching through flights array list
  	// If matching flight is not found, set instance variable errorMsg (see at top) and return null 
    // initiazlie variables
    boolean found = false;
    int index = 0;
    // loop through flights and check if flight number is found, if so set found to be true, index equal to i and break
  	for (int i = 0; i < flights.size(); i++){
      if (flightNum.equalsIgnoreCase(flights.get(i).getFlightNum())){
        found = true; 
        index = i; 
        break;
      }
    }
  	// If flight found
  	//    
  	//		****beginning of long haul flight code - you may want to skip initially
  	//		check if seat type is first class and check if this is a long haul flight (Hint: use instanceof operator)
  	//    if above is true
  	//			call reserveSeat method in class LongHaulFlight
  	//			if long haul flight first class is not full
  	//				create Reservation object, set firstClass boolean variable to true in Reservation object
  	//				return reference to Reservation object
  	//			else long haul first class is full
  	//				set errorMsg and return null
  	//		***end of long haul flight code
  	//
  	//		else must be economy seat 
  	//			reserve seat on flight (see class Flight reserveSeat() and overridden reserveSeat() in class LongHaulFlight)
  	//      if flight not full
  	//				create Reservation object and return reference to Reservation object 
  	//			else set ErrorMesg (flight full) and return null

    // if found then check if seattype is first class and instance of longhaulflight
    // if so then create flight1 object and check if reserveseat with seatType is possible
    //  if so then create res1 object, set first class, and return res1
    //  else set error msg and return null
    // else check if flight is instanceof longhaulflight, if create object and try to reserve seat, if possible return reservation object
    //    else if seat type is not first class seat then reserve an economy seat and return reservation object
    //if found is null set error message and return false
    if (found){
      if (seatType.equalsIgnoreCase("First Class Seat") && (flights.get(index) instanceof LongHaulFlight)){
        LongHaulFlight flight1 = (LongHaulFlight) flights.get(index);
        if (flight1.reserveSeat(seatType)){
          Reservation res1 = new Reservation(flightNum, flights.get(index).toString());
          res1.setFirstClass();
          return res1;
        }else{
          errorMsg = "Flight " + flightNum + " is Full";
          return null;
        }
      }else{
        if (flights.get(index) instanceof LongHaulFlight){
          LongHaulFlight flight1 = (LongHaulFlight) flights.get(index);
          if (flight1.reserveSeat()){
            return new Reservation(flightNum, flights.get(index).toString());
          }
        }else if (!seatType.equalsIgnoreCase("First Class Seat")){
          if (flights.get(index).reserveSeat()){
           return new Reservation(flightNum, flights.get(index).toString());
          }
        }
        errorMsg = "Flight " + flightNum + " is Full";
        return null;
      }
    }
    errorMsg = "Flight " + flightNum + " Not Found";
  	return null; // remove when finished code above
  }
  
  /**
   * Getter method that return the error message
   * 
   * @return the string value of errorMsg
   */
  public String getErrorMessage()
  {
    // return error message
  	return errorMsg;
  }
  
  /**
   * Given a Reservation object, cancel the seat on the flight
   * 
   * @param res, reservation object
   * @return false
   */
  public boolean cancelReservation(Reservation res)
  {
  	// Get the flight number string from res
  	// Search flights to find the Flight object - if not found, set errorMsg variable and return false
  	// if found, cancel the seat on the flight (see class Flight)
    // set num to the flight number
  	String num = res.getFlightNum();
    // set found to be false
    boolean found = false;
    // set index to be 0
    int index = 0;
    // for loop through the flights ahd check if the flight number is equal to num
    // if so set found to be true, index to be i, and break
  	for (int i = 0; i < flights.size(); i++){
      if (num.equalsIgnoreCase(flights.get(i).getFlightNum())){
        found = true; 
        index = i;
        break;
      }
    }
    // if found then check if reservation is first class and instance of LongHaulFlight, if so then create object and cancel first class set
    //    else cancel economy seat
    if (found){
      if (res.firstClass && flights.get(index) instanceof LongHaulFlight){
        LongHaulFlight flight1 = (LongHaulFlight) flights.get(index);
        flight1.cancelSeat("First Class Seat");
      }else flights.get(index).cancelSeat();
    }
    // set error message and return false
    errorMsg = "Flight " + num + " Not Found";
    return false;
  	// Once you have the above basic functionality working, try to get it working for canceling a first class reservation
  	// If this is a first class reservation (see class Reservation) and the flight is a LongHaulFlight (Hint use instanceof)
  	// then cancel the first class seat on the LongHaulFlight (Hint: you will need to cast)   
  }
  
  /**
   * Sort the array list of flights by increasing departure time 
   * Essentially one line of code but you will be making use of a Comparator object below
   */
  public void sortByDeparture()
  {
    // sorts all the flights by departure time
	  Collections.sort(flights, new DepartureTimeComparator());
  }

  /**
   * Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
   * This means you will be able to compare two Flight objects by departure time
   */
  private class DepartureTimeComparator implements Comparator <Flight>
  {
    /**
     * Compares the flights departure time
     * 
     * @param a, first flight
     * @param b, second flight
     * @return, return the difference, if a is bigger than b positive, if a is less than b, negative, else they are equal so zero
     */
  	public int compare (Flight a, Flight b){
      // return the difference in departure time
      return Integer.parseInt(a.getDepartureTime()) - Integer.parseInt(b.getDepartureTime());
    }
  }

  /**
   *Sort the array list of flights by increasing flight duration  
   * Essentially one line of code but you will be making use of a Comparator object below
   */
  public void sortByDuration()
  {
    // sort flights by duration time
	  Collections.sort(flights, new DurationComparator());
  }

  /**
   * Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
   * This means you will be able to compare two Flight objects by duration
   */
  private class DurationComparator implements Comparator <Flight>
  {
    /**
     * Compare flight one and flight two by flight duration
     * 
     * @param a, first flight
     * @param b, second flight
     * @return the difference in flight duration, if a is greater than b positive, if a is less than b negative, else they are equal so zero
     */
  	public int compare (Flight a, Flight b){
      return a.getFlightDuration() - b.getFlightDuration();
    }
  }

  /**
   * Prints all aircraft in airplanes array list. 
   * See class Aircraft for a print() method
   */
  public void printAllAircraft()
  {
    // for loop for each airplane and print
    for (Aircraft i : airplanes){
      i.print();
    }
  }
  
  /**
   * Sort the array list of Aircraft objects 
   * This is one line of code. Make sure class Aircraft implements the Comparable interface
   */
  public void sortAircraft()
  {
    // sort all the airplanes
  	Collections.sort(airplanes);
  }

  /**
   * resverse a passenger seat with the flight number, passenger's name and passport number
   * 
   * @param flightNum, flight number
   * @param name, name of the passenger
   * @param passportNum, passport number of the passenger
   * @return reservation if no conflict otherwise null
   */
  public Reservation reserveSeatPassenger(String flightNum, String name, String passportNum){
    // initialize variables
    boolean found = false;
    int index = 0;
    // for loop to check if the given flight number is valid
    // if so set found to be true, index to i, and break
    for (int i = 0; i < flights.size(); i++){
      if (flights.get(i).getFlightNum().equalsIgnoreCase(flightNum)){
        found = true;
        index = i;
        break;
      }
    }
    // if found is true initialize seat number to be zero
    if (found){
      int seatNumber = 0;
      // while loop until a random seat number is generated and not taken already
      while (true){
        // generate a number within the aircraft seats
        seatNumber = random.nextInt(flights.get(index).aircraft.getNumSeats());
        if (flights.get(index).passengerSeatAvailable(seatNumber)){
          break;
        }
      }
      // create passenger object with the flight number, name, and passport number and set seatnumber to the generated number
      Passenger pass = new Passenger(flightNum, name, passportNum);
      pass.setPassengersSeat(seatNumber);
      // check if name and passport number are valid and if theres space
      // if true then return reservation reference
      if (flights.get(index).passengerSeat(pass)){
        return new Reservation(flightNum, flights.get(index).toString());
      }
    }
    // set error message and return null
    errorMsg = "Try again!";
    return null;
  }

  /**
   * Cancels the passenger seat on the flight
   * 
   * @param flightNum, the flight number of the flight
   * @param name, the passenger's name
   * @param passNum, the passenger's passport number
   * @return true if successful, otherwise false
   */
  public boolean cancelPassSeat(String flightnum, String name, String passNum){
    // initialize variables
    boolean found = false;
    int index = 0;
    // loop through each flight number and check if the flight number given is valid
    // if so then set found to be true, index to be i, and break
    for (int i = 0; i < flights.size(); i++){
      if (flights.get(i).getFlightNum().equalsIgnoreCase(flightnum)){
        found = true;
        index = i;
        break;
      }
    }
    // if found and if cancelling passenger seat is successful return true
    // otherwise set error message and return false
    if (found){
      if (flights.get(index).cancelPassengerSeat(name, passNum)){
        return true;
      }
      errorMsg = "No flight " + flightnum + " with the name " + name + " and passport number " + passNum + " is found.";
      return false;
    }
    // set error message and return false
    errorMsg = flightnum + " Not Found.";
    return false;
  }

  /**
   * Checks if the flight number given is valid and print all passengers within that flight
   * 
   * @param flightNum, the flight number of the flight
   * @return true if successful, otherwise false
   */
  public boolean checkPass(String flightNum){
    // initialize variables
    boolean found = false;
    int index = 0;
    // for loop to check if the flight num is valid
    // if so then set found to be true, index to i, and break
    for (int i = 0; i < flights.size(); i++){
      if (flights.get(i).getFlightNum().equalsIgnoreCase(flightNum)){
        found = true;
        index = i;
        break;
      }
    }
    // if found print all passengers info and return true
    // else set error message and return false
    if (found){
      flights.get(index).printPassengers();
      return true;
    }
    errorMsg = flightNum + " Not Found.";
    return false;
  }
}//end class
