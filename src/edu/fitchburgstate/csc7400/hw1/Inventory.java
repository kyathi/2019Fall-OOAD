package edu.fitchburgstate.csc7400.hw1;
/*
 * class: object-oriented Design and Analysis
 * professor:Orlando Montalvo
 * Assignment:HW 1
 * 
 * student:Abha kumari
 * Date: 2019-09-16
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 *  inventory contains  all the informations about the all type of guitar available in the store
 * 
 * @author abhak
 *
 */
 

public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
  /**
   * full constuctor
   * 
   * @param serialNumber manufacture serial numbers
   * @param price store price
   * @param builder the guitar builder
   * @param model the manufacture model
   * @param type guitar type(electric/accoustic)
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
   * Return  information about the guitar in the store
   * @param serialNumber manufacturer serial number
   * @return guitar if serial number match else return null
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
   * search inventory and returns list of matching guitars.Finds the guiters by matching 
   * on provided parameters.
   * @param searchGuitar search the specific type of guitar 
   * @return guitar if match found else return null
   */
  public Guitar search(Guitar searchGuitar) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      /**
       * return the name of manufacturer and match with the required manufaturer,if it match
       * then it will continue 
       * 
       */
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitar.getManufacturer())))
         /**
       * return the model of guitar and match with the required guitar,if it match
       * then it will continue
       */
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitar.getModel())))
        continue;
      /**
       * return the type of guitar and match with the required type of guitar,if it match
       * then it will continue
       */
      String type = searchGuitar.getType();
      if ((type != null) && (!searchGuitar.equals("")) &&
          (!type.equals(guitar.getType())))
        continue;
       /**
       * return the type of backwood and match with the requirement,if it match
       * then it will continue
       */
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equals(guitar.getBackWood())))
        continue;
        /**
       * return the type of topwood and match with the requirement,if it match
       * then it will continue
       */
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equals(guitar.getTopWood())))
        continue;
      return guitar;
    }
    return null;
  }
}
