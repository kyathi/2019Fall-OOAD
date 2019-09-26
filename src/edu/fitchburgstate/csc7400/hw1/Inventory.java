import com.sun.tools.javac.util.List;

/** 
* Class: Object oriented analysis and design
* Professor: Orlando Montalvo
* Assignment: HW 1
* Student name: Vineela Vemula
package edu.fitchburgstate.csc7400.hw1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
*Inventory contains all different types of guitars that are available in store
*
* @author vineela vemula
*
*/
public class Inventory { 
	
  //It contains all the list of guitars//
  private List<Guitar> guitars;
  /**
     *constructor
     *@param serialNumber
     *@param price - Price in store
     *@param builder - Guitar's producer
     *@param model - Guitar model
     *@param type - Type of Guitar
     *@param backwood - Type of wood used for Guitar's body
     *@param topWood - Type of wood used for Guitar's face
     */
 
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
//Add new guitar to the list
  
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
   /**
   *Returns guitar particulars with respect to the serial number
   *@param serialNumber - Manufacturer serial number
   **/
  
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
  * Returns the guitar which matches with the requirement 
  * or else returns Null 
  *@param Search for specific type of guitar
  *@return
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
