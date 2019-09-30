/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 *
 * Date: 2018-09-03
 *
 * Student: Nodir Nabiev
 */

package edu.fitchburgstate.csc7400.hw1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory maintains records of guitars inventory from Rick's music store.
 *
 * @author Nodir.Nabiev
 * Date: 2019-09-18
 */
public class Inventory {

  private List<Guitar> guitars;

  /**
   * Class constructor specifying list of guitars to create in the inventory.
   */
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }

  /**
   * Adds a new guitar with specified parameters to the inventory.
   *
   * @param serialNumber guitar manufacturer serial number
   * @param price guitar price
   * @param builder guitar builder
   * @param model guitar model
   * @param type guitar type (electric/accoustic)
   * @param backWood guitar back wood type
   * @param topWood guitar face wood type
   */
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }

  /**
   * Gets a guitar with matched serial number from the inventory.
   *
   * @param serialNumber guitar manufacturer serial number
   * @return guitar with specified guitar manufacturer serial number, null if no match found
   *
   * @precondition inventory must be initialized
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
   * Searches guitars inventory and returns list of matching guitars.
   * Finds guitars by matching specified guitar parameters in the inventory.
   *
   * @param searchGuitar guitar with specified guitar features
   * @return collection of guitars containing specified guitar features, null if not matched
   *
   * @precondition inventory must be initialized
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
