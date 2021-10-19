// import ArrayList and Scanner
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Flight System for one single day at YYZ (Print this in title) Departing flights!!
 * Based on the user input the class calls other classes and does things
 * 
 * @author Gary Huang
 * @version 1.0
 * @since April 14, 2021
 */
public class FlightReservationSystem
{
	/**
	 * The main program
	 * @param args
	 */
	public static void main(String[] args)
	{
		// try to do the following code
		try{
			// creates FlightManager object
			FlightManager manager = new FlightManager();
			// ccreates an Reservation arraylist
			ArrayList<Reservation> myReservations = new ArrayList<Reservation>();	// my flight reservations

			// Creates a scanner object that gets user input
			Scanner scanner = new Scanner(System.in);
			System.out.print(">");

			// while there is user input do the following code
			while (scanner.hasNextLine())
			{
				// set user input to the next given input
				String inputLine = scanner.nextLine();
				// if the input is empty or null print and continue
				if (inputLine == null || inputLine.equals("")) 
				{
					System.out.print("\n>");
					continue;
				}
				// creates a scanner object within inputed line
				Scanner commandLine = new Scanner(inputLine);
				// set action to next user input
				String action = commandLine.next();
				// if action is null or empty print and continue
				if (action == null || action.equals("")) 
				{
					System.out.print("\n>");
					continue;
				}
				// else if the action is q or quit (ignore case) then return nothing
				else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
					return;
				// else if action is equals (ignore case) to list
				else if (action.equalsIgnoreCase("LIST"))
				{
					// print all the flights
					manager.printAllFlights(); 
				}
				// else if action is equals (ignore case) to res then do the following code
				else if (action.equalsIgnoreCase("RES"))
				{
					// define the following variables
					String flightNum = null;
					String passengerName = "";
					String passport = "";
					String seat = "";
					// if there is a next word set it to flight number
					if (commandLine.hasNext())
					{
						flightNum = commandLine.next();
					}
					// if there is a next word set it to passenger's name
					if (commandLine.hasNext())
					{
						passengerName = commandLine.next();
					}
					// if there is a next word set it to passenger's passport
					if (commandLine.hasNext())
					{
						passport = commandLine.next();
					}
					// if there is a next word set it to seat
					if (commandLine.hasNext())
					{
						seat = commandLine.next();
						// try to do the following code
						try{
							// create reservation object
							Reservation res = manager.reserveSeatOnFlight(flightNum, passengerName, passport, seat);
							// if reservation is not null
							if (res != null){
								// add reservation to my reservations
								myReservations.add(res);
								// print reservation
								res.print();
							}
						// catch flight is full exception
						}catch(FlightFullException e){
							// print
							System.out.println(e.toString());
						// catch seat is not found
						}catch(SeatNotFoundException e){
							// print
							System.out.println(e.toString());
						// catch seat is taken
						}catch(SeatOccupiedException e){
							// print
							System.out.println(e.toString());
						// catch duplication passenger
						}catch(DuplicatePassengerException e){
							// print
							System.out.println(e.toString());
						}
					}
				}
				// else if action is equals (ignore case) cancel then do the following code
				else if (action.equalsIgnoreCase("CANCEL"))
				{
					// initialize variables
					String flightNum = null;
					String passengerName = "";
					String passport = "";
					// if there is a next word set it to flight number
					if (commandLine.hasNext())
					{
						flightNum = commandLine.next();
					}
					// if there is a next word set it to passenger's name
					if (commandLine.hasNext())
					{
						passengerName = commandLine.next();
					}
					// if there is a next word set it to passenger's passport
					if (commandLine.hasNext())
					{
						passport = commandLine.next();
						// set index to my reservation index of new reservation
						int index = myReservations.indexOf(new Reservation(flightNum, passengerName, passport));
						// if reservation is found
						if (index >= 0)
						{
							// try
							try {
								// cancel reservation
								manager.cancelReservation(myReservations.get(index));
								// remove from my reservations
								myReservations.remove(index);
							// catch passenger not in manifest
							}catch(PassengerNotInManifestException e){
								// print
								System.out.println(e.toString());
							}
						}else
							// else print flight number is not found in reservation
							System.out.println("Reservation on Flight " + flightNum + " Not Found");
					}
				}
				// else if action is equals (ignore case) seats then do the following code
				else if (action.equalsIgnoreCase("SEATS"))
				{
					// set flight number to be empty
					String flightNum = "";
					// if there is a next word
					if (commandLine.hasNext())
					{
						// set flight number to the next word
						flightNum = commandLine.next();
						// print all seats
						manager.printSeatMap(flightNum);
					}
				}
				// else if action is equals (ignore case) pasman then do the following code
				else if (action.equalsIgnoreCase("PASMAN")){
					// initialize flight number to be empty
					String flightNum = "";
					// if there is a next word
					if (commandLine.hasNext()){
						// set flight number to be the next word
						flightNum = commandLine.next();
						// print manifest of that flight num
						manager.printManifest(flightNum);
					}				
				}
				// else if action is equals (ignore case) myres then do the following code
				else if (action.equalsIgnoreCase("MYRES"))
				{
					// loop through each reservation and print
					for (Reservation myres : myReservations)
						myres.print();
				}
				// print
				System.out.print("\n>");
				
			}
		// catch if file is not found
		}catch(FileNotFoundException e){
			// print
			System.out.println(e.toString());
		}
	}
}//ends class

