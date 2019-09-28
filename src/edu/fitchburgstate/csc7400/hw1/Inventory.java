/**
 * Class : Object-oriented design and analysis
 * Assignment 1
 * student Name : Sravanthi sribhashyam
 */
package edu.fitchburgstate.csc7400.hw1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *  Inventory contains list of available guitars
 *  
 *
 */

public class Inventory {

  /**
  * Guitars inventory list	
  */
  private List<Guitar> guitars;
  
  /**
   * Constructor
   * Initializes guitar inventory list
   */
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }

  
  /**
 * Adds a Guitar to the Inventory
 * 
 * @param string serialNumber Defines the serial number for Guitar
 * @param price store price
 * @param builder who is the builder 
 * @param model the manufacturers model
 * @param type guitar type (electric/accoustic)
 * @param backWood the wood used for the guitar body
 * @param topWood the wood used for the guitar's face
 */
public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }

 /**
 * Gets Guitar from the inventory
 * 
 * @param serialNumber Defines the serial number for Guitar
 * @return Guitar that matches the serial number
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
 * Searches for Guitar in the Inventory
 * @param searchGuitar Search guitar in inventory with guitar description provided by customer
 * @return Guitar that matches the description
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
