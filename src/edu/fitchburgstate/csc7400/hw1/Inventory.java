package edu.fitchburgstate.csc7400.hw1;
/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Student: Yamini 
 * Date: 2019-09-24
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory class contains available guitars from Rick's music store
 *@author HeadFirstOODA
 */
public class Inventory {
	
	/**
	 * Inventory List of guitars
	 */
  private List<Guitar> guitars;
  
  /**
 	 * Default Constructor
 	 * initializes the guitar list
 	 */
public Inventory() {
    guitars = new LinkedList<Guitar>();
  }

/**
 * This particular method adds guitar to the inventory
 * 
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
 
 /**
	 * Returns a guitar to the specified serial number
	 * @param serialNumber
	 * @return a guitar with unique serial number
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
	 * returns a guitar from the inventory based on the given guitar specification
	 * @param searchGuitar
	 * @return guitar
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
