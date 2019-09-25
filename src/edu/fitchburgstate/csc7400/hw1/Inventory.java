/**
 * Class      :  Object-Oriented Analysis and Design
 * Professor  :  Orlando Montalvo
 * Assignment :  HW-1
 * Date       :  09-24-2019
 * @author       Sveerapu
 *
 */

package edu.fitchburgstate.csc7400.hw1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Inventory contains list of guitars available in store
 */
public class Inventory {
  
  private List<Guitar> guitars;// Guitar list

  /*
  *Initialize Guitar List
  */
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
  /*
 * addGuitar adds guitar details to the inventory
 * @param serialNumber 
 * @param price store
 * @param builder
 * @param model
 * @param type guitar type
 * @param backWood
 * @param topWood
   */

  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  /*
   *Searches for matching serialNumber in Inventory                       
   *@param serialNumber
   *@return Guitar if same serial Number is found in Inventory else Null.
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
  /*
   *As per guitar details provided by customer searches matching guitar in Inventory
   *@param searchGuitar
   *@return Matching guitar if found in inventory else null
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
