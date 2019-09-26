/*
 * Class: Object-Oriented Analysis and Design
 * Instructor:Orlando Montalvo
 * Assignment: HW 1
 * Date: 2019-09-25
 * Authors: Kboppana, parkerrobc
 */

package edu.fitchburgstate.csc7400.hw1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
* Inventory contains all guitars available in the store
*   
* @author Kboppana
* @author parkerrobc
*/
public class Inventory {

  /**
   * Inventory of guitars
   */
  private List<Guitar> guitars;

  /**
   * Constructor for the inventory
   */
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }

  /**
   * Creates then adds a guitar to the inventory
   *
   * @param serialNumber guitar's serial number
   * @param price guitar's price
   * @param builder guitar's builder
   * @param model guitar's model
   * @param type guitar's type
   * @param backWood guitar's back-wood
   * @param topWood guitar's top-wood
   */
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }

  /**
   * Returns guitar based on serial number passed. If guitar does not exist, null is returned
   *
   * @param serialNumber guitar's serial number
   *
   * @return guitar || null
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
   * Searches inventory given a guitar with any manufacturer, model, type, back-wood, or top-wood characteristic
   * then returns the guitar from inventory or null if no guitar is found
   *
   * @param searchGuitar for specific type of guitar
   *
   * @return guitar || null
   */
  public Guitar search(Guitar searchGuitar) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();

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
