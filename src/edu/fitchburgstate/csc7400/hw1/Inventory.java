/**
* Class: Object-Oriented Design and Analysis

* Professor: Orlando Montalvo

 * Assignment: HW 1

 * Student: Vinitha Gaddampally

 * Date: 2019-09-20
 */
package edu.fitchburgstate.csc7400.hw1;

// The inventory class

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* since Inventory is a real-world entity, here it makes sense to instantiate it in the main method*/

public class Inventory {
	/**

  *  Rick's guitar inventory list

  */
  List<Guitar> guitars;
  /**
  * Constructor
  *
  * Initializes guitar inventory list

   */
// constructor initializes Rick's guitar inventory list
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
  

public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
/*guitar contains the information needed to keep track of a type of guitar from Rick's music store*/
  public Guitar getGuitar(String serialNumber) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  /* This method returns a list of guitars that matches with the specification of search object*/
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
