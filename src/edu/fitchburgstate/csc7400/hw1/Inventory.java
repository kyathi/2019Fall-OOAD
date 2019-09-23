/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2019-09-22
 * student: Tamjid Shaik
 */
package edu.fitchburgstate.csc7400.hw1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Inventory keeps a searchable collection of Guitars. It is meant to be use
 * to find matching guitars for customers.
 *
 * @author Tamjid Shaik
 */
public class Inventory {
  private List<Guitar> guitars;
/**
     * Adds guitar details to list
     * @param serialNumber
     * @param price
     * @param builder
     * @param model
     * @param type
     * @param backWood
     * @param topWood
     */
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
      /**
     * Returns deatils of guitar for a particular serial number
     * @param serialNumber
     * @return
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
     * Search guitar in inventory with guitar description provided by customer
     * @param searchGuitar
     * @return Details for searched guitar else returns null if guitar not found
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
