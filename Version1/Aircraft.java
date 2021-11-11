/**
 * This class models an aircraft type with a model name, a maximum number of economy seats, and a max number of forst class seats 
 * 
 * Add code such that class Aircraft implements the Comparable interface
 * Compare two Aircraft objects by first comparing the number of economy seats. If the number is equal, then compare the
 * number of first class seats 
 * 
 * This class implements Comparable and contains information about the number of economy seats, first class seats, and the model.
 * 
 * Student id: 501039657
 * @author Gary Huang
 * @version 1.0
 * @since March 20, 2021
 */
public class Aircraft  implements Comparable <Aircraft>
{
	// Initialize variables:
	// numEconomySeats to store an integer value of the maximum number of economy seats
	// numFirstClassSeats to store an integer value of maximum number of first class seats
	int numEconomySeats;
	int numFirstClassSeats;
	// model to store an string value of the aircraft's model
	String model;
	
	/**
	 * Constructor, set the parameters seats and model to variables
	 * 
	 * @param seats, the number of economy seats in the aircraft
	 * @param model, the model of the aircraft
	 */
	public Aircraft(int seats, String model)
	{
		// Set the value of the variables to the parameters and set number of first class seats to zero
		this.numEconomySeats = seats;
		this.numFirstClassSeats = 0;
		this.model = model;
	}

	/**
	 * Constructor, set the parameters economy, firstClass, and model to variables
	 * 
	 * @param economy, the number of economy seats in the aircraft
	 * @param firstClass, the number of first class seats in the aircraft
	 * @param model, the model of the aircraft
	 */
	public Aircraft(int economy, int firstClass, String model)
	{
		// Set the value of the variables to the parameters
		this.numEconomySeats = economy;
		this.numFirstClassSeats = firstClass;
		this.model = model;
	}
	
	/**
	 * Getter method that returns the integer value of number of economy seats in the aircraft
	 * 
	 * @return the number of economy seats in the aircraft
	 */
	public int getNumSeats()
	{
		// return the number of economy seats in the aircraft
		return numEconomySeats;
	}
	
	/**
	 * Getter method that returns the total number of seats in the aircraft
	 * 
	 * @return the number of seats in the aircraft (economy and first class seats)
	 */
	public int getTotalSeats()
	{
		// return the sum of number of economy seats and number of first class seats in the aircraft
		return numEconomySeats + numFirstClassSeats;
	}
	
	/**
	 * Getter method that returns the number of first class seats in the aircraft
	 * 
	 * @return the number of first class seats in the aircraft
	 */
	public int getNumFirstClassSeats()
	{
		// return the number of first class seats in the aircraft
		return numFirstClassSeats;
	}

	/**
	 * Getter method that returns the model of the aircraft
	 * 
	 * @return the model of the airccraft in a stri
	 */
	public String getModel()
	{
		// returns the model of the aircraft
		return model;
	}

	/**
	 * Setter method that sets the model value to the given value
	 * 
	 * @param model, the model of the aircrafft
	 */
	public void setModel(String model)
	{
		// Set the model value to the value given
		this.model = model;
	}

	/**
	 * Prints all the information about the aircraft
	 */
	public void print()
	{
		//Print the model, number of economy seats and first class seats
		System.out.println("Model: " + model + "\t Economy Seats: " + numEconomySeats + "\t First Class Seats: " + numFirstClassSeats);
	}

	/**
	 * Write a compareTo method that is part of the Comparable interface
	 * compares to aircraft based on the number of seats they contain
	 * 
	 * @param other, the other aircraft
	 * @return an integer value, positive if greater than, negative if less than and zero if equal
	 */
	public int compareTo(Aircraft other){
		// if the aircrafts' have the same amount of economy seats then return the differencee in first class seats
		// positive if greater than, negative if less than and zero if equal
		if (this.numEconomySeats == other.numEconomySeats){
			return this.getNumFirstClassSeats() - other.getNumFirstClassSeats();
		}
		// otherwise returns the difference in economy seats
		// positive if greater than, negative if less than and zero if equal
		return this.numEconomySeats - other.numEconomySeats;
	}
}//ends class
  
