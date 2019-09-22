package edu.fitchburgstate.csc7400.hw1;
/**
 * Course Name : Object Oriented Design and Analysis
 * Professor Name : Orlando Montalvo
 * Date : 2019-09-18
 * Assignment - HW1
 * Author : Divya Mallepally (01398602)
 */
 
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *  Inventory contains all the informations about the all type of guitar available in the store							   
 * 
 * @author dmallepa
 *
 */
 
public class Inventory {
  private List<Guitar> guitars;
  /**
   * Constructor Inventory initialized here
   */
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
  
  /**
   * Adds the guitar to the list.
   *
   * @param serialNumber is manufacture serial numbers.
   * @param price is store price.
   * @param builder is the guitar builder.
   * @param model is the manufacturer model.
   * @param type is the guitar type i.e., electric or accoustic.
   * @param backWood is the wood used for the guitar body.
   * @param topWood is the wood used for the guitars face.
   */

  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
  /**
   * Returns the information about the guitar in the store
   *
   * @param serialNumber is the manufacturer serial number
   * @return guiter which associated to the input param serialNumber or null
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
   * Search inventory and returns list of matching guitars. 
   *
   * @param searchGuitar search the specific type of guitar.
   *
   * @return Guiter by matching attributes like manufacturer, model, type, backwood, topwood or null.
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
