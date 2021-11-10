/**
 * The type of airplanes, contains information on seats
 * 
 * @author Gary Huang
 * @version 1.0
 * @since April 14, 2021
 */
public class Aircraft implements Comparable<Aircraft>
{
  // define variables
  int numEconomySeats;
  int numFirstClassSeats;
  String model;
  // define 2d array seat layout
  String [][] seatLayout;
  
  /**
   * Constructor, initialize variables
   * 
   * @param seats, the number of economy seats in the airplane
   * @param model, the model of the airplane
   */
  public Aircraft(int seats, String model)
  {
	// set the following variables to the given values
  	this.numEconomySeats = seats;
  	this.numFirstClassSeats = 0;
  	this.model = model;
	// call setSeatLayout method to set the 2d array seats
	setSeatLayout(seats);
  }

  /**
   * Constructor, initialize variables
   * 
   * @param economy, the number of economy seats in the airplane
   * @param firstClass, the number of first class seats in the airplane
   * @param model, the model of the airplane
   */
  public Aircraft(int economy, int firstClass, String model)
  {
	// set the following variables to the given values
  	this.numEconomySeats = economy;
  	this.numFirstClassSeats = firstClass;
  	this.model = model;
	// call setSeatLayout method to set the 2d array seats
	setSeatLayout(economy, firstClass);
  }
  
  /**
   * Set the 2d array seat layout given the number of economy seats
   * 
   * @param seats, the number of economy seats
   */
  public void setSeatLayout(int seats){
    // create an array of letters
    String [] letter = {"A", "B", "C", "D"};
    // create 2d array with the size of 4 and number of seats divivde by 4
    seatLayout = new String[4][seats/4];
    // Nested for loop to set each element in the 2d array
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < seats/4; j++){
        // set an element to a seat (1A, 2A, etc...)
        seatLayout[i][j] = (j+1) + letter[i];
      }
    }
  }

  /**
   * Set the 2d array seat layout given the number of economy seats and first class seats
   * 
   * @param economy
   * @param firstClass
   */
  public void setSeatLayout(int economy, int firstClass){
    // set seats to be the total number of seats
    int seats = economy + firstClass;
    // create an array of letters
    String [] letter = {"A", "B", "C", "D"};
    // create 2d array with the size of 4 and number of seats divide by 4
    seatLayout = new String[4][seats/4];
    // nested for loop to set each element in the 2d array
    for (int i = 0; i < 4; i++){
      // create first class seats to be number of first class seats divide by 4
      int firstclassSeats = firstClass/4;
      for (int j = 0; j < seats/4; j++){
        // if first class seats are not zero, set an element to a seat (1A+, 2A+, 3A+, etc...)
        if (firstclassSeats != 0){
          seatLayout[i][j] = (j+1) + letter[i] + "+";
          // lower the number of first class seats by 1
          firstclassSeats--;
        // else set an element to a seat (1A, 2A, etc...)
        }else{
          seatLayout[i][j] = (j+1) + letter[i];
        }
      }
    }
  }

  /**
   * Getter Method, return the number of economy seats
   * @return numEconomySeats
   */
  public int getNumSeats()
  {
    // return the integer value of economy seats
	  return numEconomySeats;
  }

  /**
   * Getter Method, returns the sum of economy seats and first class seats
   * @return total number of seats
   */
  public int getTotalSeats()
  {
    // return total
	  return numEconomySeats + numFirstClassSeats;
  }

  /**
   * Getter Method, returns the number of first class seats
   * @return the number of first class seats
   */
  public int getNumFirstClassSeats()
  {
    // return number of first class seats
	  return numFirstClassSeats;
  }

  /**
   * Getter Method, returns the model of the aircraft
   * @return model of aircraft
   */
  public String getModel()
  {
    // return model
	  return model;
  }

  /**
   * Setter Method, sets the model the of aircrarft
   * @param model, the model of the aircraft
   */
  public void setModel(String model)
  {
    // set the model of the aircraft to the given value
	  this.model = model;
  }

  /**
   * Prints the flight information
   */
  public void print()
  {
    // print
 	  System.out.println("Model: " + model + "\t Economy Seats: " + numEconomySeats + "\t First Class Seats: " + numFirstClassSeats);
  }

  /**
   * Compares aircraft if they have same number of economy seats return difference of first 
   * class seats otherwise return the difference of economy seats
   * 
   * @param other, the other aircraft object
   * @return
   */
  public int compareTo(Aircraft other)
  {
    // if number of economy seats are equal
  	if (this.numEconomySeats == other.numEconomySeats)
      // return difference between first class seats
  		return this.numFirstClassSeats - other.numFirstClassSeats;
  	// return difference between economy seats
  	return this.numEconomySeats - other.numEconomySeats; 
  }
}//ends class
