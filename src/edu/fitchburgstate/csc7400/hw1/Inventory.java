package edu.fitchburgstate.csc7400.hw1;
/*
 * class:Object Oriented Analysis and Design
 *Instructor:Orlando Montalvo
 *Assignment:Homework 1
 *Student Name:Sana Saleem
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
*customers can buy suitable guitars with the help on inventory that have all information
 about guitars available in stock.
*
* @author sana
*
*/

public class Inventory {
  private List<Guitar> guitars;
  /**
     *constructor
     *@param serialNumber manufacture serial nummbers
     *@param price price store price
     *@param builderbuilder the guitar builder
     *@param model model the manufacture model
     *@param type guitar type (electric /accoustic)   
    *@param backwood wood used for the guitar body
     *@param topWood wood used for the guitar's face
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
   *Returns about guitar particulars based on manufacturer serial number
   *@param serialNumber
   *@return
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
  * Search for matching guitar in inventory and return list
  *if any returns information else return Null 
  *@param Search guitar and specific type of guitar
  *@return
  */
  
  public Guitar search(Guitar searchGuitar) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      /**
      *return the name of manufacturer and match with the required manufacturer
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitar.getManufacturer())))
        continue;
        /**
        *return the name of manufacturer and match with the required manufacturer,if it match
        *then it will continue
        */
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitar.getModel())))
        continue;
      /**
      *return model of guitar and match with required guitar
      */
      String type = searchGuitar.getType();
      if ((type != null) && (!searchGuitar.equals("")) &&
          (!type.equals(guitar.getType())))
        continue;
      /**
      *return the type of guitar and match with the required type of guitar, if it match
      *then it will continue
      */
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equals(guitar.getBackWood())))
        continue;
      /**
      *return the backwood and match with requirement, if it match
      *then it will continue
      */
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equals(guitar.getTopWood())))
        continue;
      /**
      * return the topwood and match with requirement, if it match
      *then it will continue
      */
      return guitar;
    }
    return null;
  }
}
