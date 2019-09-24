/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Student: Poorani Jagadeesan
 * Date: 2019-09-18
 */
package edu.fitchburgstate.csc7400.hw1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory contains list of available guitars in Rick's music store
 *
 * @author HeadFirstOODA
 *
 */
public class Inventory {
  /**
   *  Rick's guitar inventory list
   */

  private List<Guitar> guitars;

  /**
   * Constructor
   *
   * Initializes guitar inventory list
   */

  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }

  /**
   * Adds guitar to the Rick's guitar inventory list
   *
   * @param serialNumber manufacturer serial number
   * @param price store price
   * @param builder the guitar's manufacturer
   * @param model the manufacturers model
   * @param type guitar type (electric/acoustic)
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
   * Returns a guitar for a given serial number
   *
   * @param serialNumber manufacturer serial number
   * @return A guitar with unique serial number
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
   * Returns a guitar from the inventory for a given guitar specifications
   *
   * @param searchGuitar guitar specifications
   * @return guitar
   *
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
