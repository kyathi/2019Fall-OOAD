package edu.fitchburgstate.csc7400.hw1;
/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * 
 * Date: 2018-09-18
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory gives information about stock and the guitars available 
 * in Rick's music store that the user searches.
 * 
 * @author HeadFirstOODA
 *
 */
public class Inventory {
  private List<Guitar> guitars; //list of guitars
  
   /**
   * User defined constructor 
   * 
   * NB: No need @params because it just initialize the list.
   */
  public Inventory() {
    guitars = new LinkedList<Guitar>(); 
  }
  
  /**
   * Adds the guitar to the list.
   * 
   * @param serialNumber manufacturer serial number
	 * @param price store price
	 * @param builder the guitar's manufacturer
	 * @param model the manufacturers model
	 * @param type guitar type (electric/accoustic)
	 * @param backWood the wood used for the guitar body
	 * @param topWood the wood used for the guitar's face
   *
   */
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  
  /**
   * Returns the guitar to the corresponding serialNumber.
   * 
   * @param serialNumber manufacturer serial number
   * @return if found returns the guitar
   */
  public Guitar getGuitar(String serialNumber) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  
  /**
   * Searches and returns the matched guitar that the user looks.
   *
   * @params searchGuitar
   * @return matched guitar 
   */
  public Guitar search(Guitar searchGuitar) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitar.getManufacturer())))
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitar.getModel())))
        continue;
      String type = searchGuitar.getType();
      if ((type != null) && (!searchGuitar.equals("")) &&
          (!type.equals(guitar.getType())))
        continue;
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equals(guitar.getBackWood())))
        continue;
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equals(guitar.getTopWood())))
        continue;
      return guitar;
    }
    return null;
  }
}
