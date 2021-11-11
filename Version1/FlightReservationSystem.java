/**
 * Gets the user input and calls certain class based on what the user inputs and stores the information if applicable.
 * 
 * Student id: 501039657
 * @author Gary Huang
 * @version 1.0
 * @since March 20, 2021
 */

 // import IOException, ArrayList, NoSuchElementException, and Scanner
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Flight System for one single day at YYZ (Print this in title) Departing flights!!

/**
 * Creates the class FlightReservationSystem
 */
public class FlightReservationSystem
{
	/**
	 * This is the main part of the program 
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Create a FlightManager object
		FlightManager manager = new FlightManager();

		// List of reservations that have been made
		ArrayList<Reservation> myReservations = new ArrayList<Reservation>();	// my flight reservations

		// Initialize scanner to get user input
		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// While scanner has next line do the following code
		while (scanner.hasNextLine())
		{
			// Get the next line and set it to inputLine
			String inputLine = scanner.nextLine();
			// if inputLine if null or is empty continue
			if (inputLine == null || inputLine.equals("")) continue;

			// The command line is a scanner that scans the inputLine string
			// For example: list AC201
			Scanner commandLine = new Scanner(inputLine);
			
			// The action string is the command to be performed (e.g. list, cancel etc)
			String action = commandLine.next();

			// if the action is equal to null or empty continue
			if (action == null || action.equals("")) continue;

			// if the action equals q or quit ignore the case, then return nothing
			if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;
			
			// List all flights
			//else if the action equals list ignore cast then print all flights
			else if (action.equalsIgnoreCase("LIST"))
			{
				//call manager and print all flights
				manager.printAllFlights(); 
			}
			// Reserve a flight based on Flight number string (example input: res AC220)
			else if (action.equalsIgnoreCase("RES"))
			{
				// Get the flight number string from the commndLine scanner (use hasNext() to check if there is a
				// flight number string entered
				// define a empty string flightNumber
				String flightNumber = "";
				// while commandLine has a next word, set flightNumber to the next word
				while (commandLine.hasNext()){
					flightNumber = commandLine.next();
				}
				// call reserveSeatOnFlight() method in manager passing in the flight number string
				// A reference to a Reservation object is returned. Check to make sure it is not == null
				// If it is null, then call manager.getErrorMessage() and print the message
				// If it is not null, add the reservation to the myReservations array list and print the reservation (see class Reservation)
				// creates a object res1 from the value return from manager.reservseSeatOnFlight() with economy seat
				Reservation res1 = manager.reserveSeatOnFlight(flightNumber, "Economy Seat");
				// if res1 is equal to null then print error message
				// else add res1 to myReservations arrayList and print res1
				if (res1 == null){
					System.out.println(manager.getErrorMessage());
				}else{
					myReservations.add(res1);
					res1.print();
				}
			}
		  // Reserve a first class seat on a flight based on Flight number string (example input: res AC220)
			else if (action.equalsIgnoreCase("RESFCL"))
			{
				// Same as above except call 
				// manager.reserveSeatOnFlight() and pass in the flight number string as well as the string constant:
				// LongHaulFlight.firstClass (see class LongHaulFlight)
				// Do the LongHaulFlight class and this command after all the basic functionality is working for regular flights
				// define a string variable flightNumber with an empty string
				String flightNumber = "";
				// while commadLine has a next word assign flightNumber to the next word
				if (commandLine.hasNext()){
					flightNumber = commandLine.next();
				}
				// creates a object res1 from the value return from manager.reservseSeatOnFlight() with first class seat
				Reservation res1 = manager.reserveSeatOnFlight(flightNumber, LongHaulFlight.firstClass);
				// res1 equals nu,, then print error message
				// else add res1 to myReservations array list and print res1 + FCL
				if (res1 == null){
					System.out.println(manager.getErrorMessage());
				}else{
					myReservations.add(res1);
					res1.print();
					System.out.println("\tFCL");
				}
			}
			// Query the flight manager to see if seats are still available for a specific flight (example input: seats AC220)
		  // This one is done for you as a guide for other commands
			else if (action.equalsIgnoreCase("SEATS"))
			{
				// Define flightNum to equal to null
				String flightNum = null;

				// if commandLine has a next word then set flightNum to the next word
				if (commandLine.hasNext())
				{
					flightNum = commandLine.next();
					// if theres seat available then print seats are available other print error message
					if (manager.seatsAvailable(flightNum))
					{
						System.out.println("Seats are available");
					}
					else
					{
						System.out.println(manager.getErrorMessage());
					}
				}
			}
			// Cancel an existing reservation (example input: cancel AC220) 
			else if (action.equalsIgnoreCase("CANCEL"))
			{
        // get the flight number string from commandLine scanner (check if there is input first)
				// Use the flight number to find the Reservation object in the myReservations array list
				// If the reservation is found,  
				// 		call cancelReservation() method in the flight manager
				//    remove the reservation from myReservations
				// If the reservation is not found, print a message (see video)
				// define flightNumber to an empty string
				String flightNumber = "";
				// if commandLine has next word, set it to flight number else print error message
				if (commandLine.hasNext()){
					flightNumber = commandLine.next();
					// for loop in myReservations and check if the reservation number is equal the given flight Number
					// if so then set index to i and break
					for (int i = 0; i < myReservations.size(); i++){
						if (myReservations.get(i).getFlightNum().equalsIgnoreCase(flightNumber)){
							// cancel reservation and remove it from the arraylist
							manager.cancelReservation(myReservations.get(i));
							myReservations.remove(myReservations.get(i));
							break;
						}
					}
				//else print the error message
				}else{
					System.out.println(manager.getErrorMessage());
				}
			}
      		// Print all the reservations in array list myReservations
			else if (action.equalsIgnoreCase("MYRES"))
			{
				// loop through the reservation and print each one
				// if resservation is first class then print FCL
				for (Reservation i : myReservations){
					i.print();
					if (i.isFirstClass()){	
						System.out.println("\tFCL");
					}
				}
			}
			// Print the list of aircraft (see class Manager)
			else if (action.equalsIgnoreCase("CRAFT"))
		  {
			  // print all aircrafts
			  manager.printAllAircraft();
			}
			// These commands can be left until we study Java interfaces
			// Feel free to implement the code in class Manager if you already understand interface Comparable
			// and interface Comparator
			else if (action.equalsIgnoreCase("SORTCRAFT"))
		  {
			// sort all aircrafts
		  	manager.sortAircraft();
		  }
		  else if (action.equalsIgnoreCase("SORTBYDEP"))
		  {
			  // sort all aircrafts by departure time
			  manager.sortByDeparture();
			  
		  }
		  else if (action.equalsIgnoreCase("SORTBYDUR"))
		  {
			  // sort all aircrafts by duration
			  manager.sortByDuration();
		  }
		  else if (action.equalsIgnoreCase("RESPSNGR"))
		  {
			// try to do the following code
			try
			{
				// Initialize variables and set them to user input
				String flightNum = commandLine.next();
				String passName = commandLine.next();
				String passNum = commandLine.next();
				// if there still user input, print error msg
				// else call manager reserve seat passenger and set the returned value to res1 object
				if (commandLine.hasNext()){
					System.out.println("Error! Enter flight number, passenger's name, and passport number.");
				}else{
					Reservation res1 = manager.reserveSeatPassenger(flightNum, passName, passNum);
					// if res1 is equal to null print error message
					// else add res1 to myreservations arraylist
					if (res1 == null){
						System.out.println(manager.getErrorMessage());
					}else{
						myReservations.add(res1);
					}
					
				}
			}
			// catches no such element exception and print a friendly message
			catch(NoSuchElementException exception)
			{
				System.out.println("Error! Enter flight number, passenger's name, and passport number.");
			}
		  }
		  else if (action.equalsIgnoreCase("CNCLPSNGR"))
		  {
			// initialize the variables as empty strings
			String flightNum, name, passNum;
			flightNum = name = passNum = "";
			// try to do the following code
			try
			{
				// set the variables to the given input
				flightNum = commandLine.next();
				name = commandLine.next();
				passNum = commandLine.next();
				// if there is still more input then print a friendly error msg
				if (commandLine.hasNext()){
					System.out.println("Error! Enter flight number, passenger's name, and passport number.");
				// else call manager cancel passenger seat and if it returns true then for loop through reservations and if
				// flight number is found within the reservations, cancel reservation and remove it from arraylist
				// otherwise print error msg
				}else{
					if (manager.cancelPassSeat(flightNum, name, passNum)){
						for (int i = 0; i < myReservations.size(); i++){
							if (myReservations.get(i).getFlightNum().equalsIgnoreCase(flightNum)){
								manager.cancelReservation(myReservations.get(i));
								myReservations.remove(myReservations.get(i));
								break;
							}
						}
						// print friendly msg
						System.out.println("Flight " + flightNum + " with the name " + name + " and passport number " + passNum + " has been removed.");
					}else{
						System.out.println(manager.getErrorMessage());
					}
				}
			}
			//catch no such element exception and print a friendly message
			catch(NoSuchElementException exception)
			{
				System.out.println("Error! Enter flight number, passenger's name, and passport number.");
			}
		  }
		  else if (action.equalsIgnoreCase("PSNGRS"))
		  {
			// try the following code
			try{
				// get the next word and set it to the variable flight number
				String flightNumber = commandLine.next();
				// call manager and if its return true then print error message
				if (!manager.checkPass(flightNumber)){
					System.out.println(manager.getErrorMessage());
				}
			// catch no such element exception and print a friendly message
			}catch(NoSuchElementException exception){
				System.out.println("Error! Enter flight number.");
			}
		  }
			System.out.print("\n>");
			// close commandLine
			commandLine.close();
		}
	//close scanner
	scanner.close();
	}
}//ends class

