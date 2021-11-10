/**
 * Passenger class contains information about the passenger
 * 
 * @author Gary Huang
 * @version 1.0
 * @since April 14, 2021
 */
public class Passenger
{
	// initialize variables
	private String name;
	private String passport;
	private String seat;
	private String seatType;
	
	/**
	 * Constrcutor
	 * @param name, the passenger's name
	 * @param passport, the passenger's passport
	 * @param seat, the passenger's seat
	 * @param seatType, the seat type
	 */
	public Passenger(String name, String passport, String seat, String seatType)
	{
		// initialize variables to the given values
		this.name = name;
		this.passport = passport;
		this.seat = seat;
		this.seatType = seatType;
	}
	
	/**
	 * Construtpr
	 * @param name, the passenger's name
	 * @param passport, the passenger's passport
	 */
	public Passenger(String name, String passport)
	{
		// initialize variables to the given values
		this.name = name;
		this.passport = passport;
	}
	
	/**
	 * check if two passengers are equal by name and passport
	 * @param other, the other passenger to be compared to
	 * @return if they are equal
	 */
	public boolean equals(Object other)
	{
		// cast other to be a passenger object
		Passenger otherP = (Passenger) other;
		// return if they are equal by name and passport
		return name.equals(otherP.name) && passport.equals(otherP.passport);
	}
	
	/**
	 * Getter Method, returns seat type
	 * @return the seat type
	 */
	public String getSeatType()
	{
		// return seat tyoe
		return seatType;
	}

	/**
	 * Setter Method, sets the seat type
	 * @param seatType, the seat type
	 */
	public void setSeatType(String seatType)
	{
		// set seat type to the given value
		this.seatType = seatType;
	}

	/**
	 * Getter Method, returns name of passenger
	 * @return name of the passenger
	 */
	public String getName()
	{
		// return name
		return name;
	}

	/**
	 * Setter Method, sets the passengers name 
	 * @param name
	 */
	public void setName(String name)
	{
		// set name to the given value
		this.name = name;
	}

	/**
	 * Getter Method, returns passenger's passport
	 * @return passport
	 */
	public String getPassport()
	{
		// return passport
		return passport;
	}

	/**
	 * Setter Method, sets the passenger's passport
	 * @param passport, the passenger's passport
	 */
	public void setPassport(String passport)
	{
		// set passport to the given value
		this.passport = passport;
	}

	/**
	 * Getter Method, returns the seat
	 * @return seat of the passenger
	 */
	public String getSeat()
	{
		// returns seat
		return seat;
	}

	/**
	 * Setter Method, sets the seat of the passenger
	 * @param seat, passenger's seat
	 */
	public void setSeat(String seat)
	{
		// set seat to the given value
		this.seat = seat;
	}
	
	/**
	 * Returns the passenger's information
	 * @return a string of name, passport, and seat
	 */
	public String toString()
	{
		// return name, passport, and seat
		return name + " " + passport + " " + seat;
	}
}//ends class
