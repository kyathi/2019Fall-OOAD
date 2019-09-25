/** Class	   : Object-Oriented Design and Analysis
*   Professor  : Orlando Montalvo
*   Assignment : Home Work 1
*   Student    : Komal(@01411726)
*   Date	   : 2019-09-25
*/

package edu.fitchburgstate.csc7400.hw1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory contains a collection of Guitars. Inventory class implements methods
 * to find matching guitars for customers, adds a guitar to the inventory 
 * and retrieves details about a specific guitar. 
 * @author orlando
 * @version 1.0
 */

public class Inventory {
  private List<Guitar> guitars;
  
  //Constructor defined to initialize guitars
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
  
  /**
   * Adds a guitar with all the details to the list
   * @param serialNumber -stores manufacturer serial number
   * @param price - stores the price
   * @param builder - stores guitar's manufacturer
   * @param model - stores the guitar model
   * @param type - stores the guitar type (electric/acoustic)
   * @param backWood - stores the type of wood used for guitar body
   * @param topWood - stores the type of wood used for the guitar's face
   */
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  
   /**
   * Searches the inventory and retrieves the Guitar from the inventory based on the serialNumber of the Guitar
   * 
   * @param serialNumber - Serial number of guitar
   * @return guitar - Returns a guitar that matches with the input serial number
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
     *  searchGuitar searches for guitars based on customer preferences of various parameters 
     *  such as serialNumber ,manufacturer, price , model , type, backWood and topWood.
     *  @param searchGuitar - Guitar object with given Guitar specifications
     *  @return guitar - Returns the guitar which matches the preferences of the customer. 
     *  A null is returned if no guitar is found in the inventory.
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
