/**
 * Stores information about the flight number, name, and passport number. Extends to flight class
 * 
 * Student id: 501039657
 * @author Gary Huang
 * @version 1.0
 * @since March 20, 2021
 */
public class Passenger extends Flight{
    // Define variables
    String flightNum;
    String name;
    String passportNumber;

    /**
     * Constructor, set the following variables to default
     */
    public Passenger(){
        this.flightNum = "";
        this.name = "";
        this.passportNumber = "";
    }

    /**
     * Constructor, set the following variables to the given information
     * 
     * @param flight, the flight number
     * @param name1, the passenger's name
     * @param passNum, the passenger's passport number
     */
    public Passenger(String flight, String name1, String passNum){
        // set values to the given values
        this.flightNum = flight;
        this.name = name1;
        this.passportNumber = passNum;
    }

    /**
     * Check between two passengers if their names and passport numbers are the same
     * 
     * @param other, the other passenger
     * @return true if they have the same name and passport number otherwise false
     */
    public boolean equals(Passenger other){
        return (this.getName().equalsIgnoreCase(other.getName()) && this.getPassportNumber().equalsIgnoreCase(other.getPassportNumber()));
    }

    /**
     * Getter method, returns the flight number
     * 
     * @return flight number
     */
    public String getFlightNum(){
        // return string value of flight number
        return this.flightNum;
    }

    /**
     * Setter method, sets the flight number to the given value
     * 
     * @param num, the flight number
     */
    public void setFlightNum(String num){
        // set flight number to the given string value
        this.flightNum = num;
    }

    /**
     * Getter method, returns the name of the passenger
     * 
     * @return the name of the passenger
     */
    public String getName(){
        // return string value of name
        return this.name;
    }

    /**
     * Setter method, set the name to the given value
     * 
     * @param name1, the name of the passenger
     */
    public void setName(String name1){
        // set name to the given string value
        this.name = name1;
    }

    /**
     * Getter method, returns the passenger's passport number
     * 
     * @return the passport number of the passenger
     */
    public String getPassportNumber(){
        // return passport number
        return this.passportNumber;
    }

    /**
     * Setter method, set the passenger's passport number to the given value
     * 
     * @param passNum, the passenger's passport number
     */
    public void setPassengers(String passNum){
        // set passport number to the given string value
        this.passportNumber = passNum;
    }

    /**
     * Returns all information
     * 
     * @return string of all passenger's info (name, number, flight number, and seat number)
     */
    public String toString(){
        return "\nFlight Number: " + this.flightNum + "\nPassenger Name: " + this.name + "\nPassport Number: " + this.passportNumber + "\nSeat Number: " + this.getPassengerSeat();
    }
}//ends class