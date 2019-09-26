package edu.fitchburgstate.csc7400.hw1;
/**
 *class:Object Oriented Analysis and Design
 *Instructor:Orlando Montalvo
 *Assignment:HW1
 *Student :Chandralekha(@01411928)
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
*<h1>Class Inventory </h1> 
* this class is to track all guitar information with search feature   
* to help him match  customers with guitars from his music store.
* 
* @author Chandralekha
* @since :26-09-2019
*/

public class Inventory {
  private List<Guitar> guitars;
/**
*The inventory stores a list of all the guitars 
* that Rick currently has available.
*/
  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }
/**
* the method addGuitar takes serialNumber, price, builder,model,type,backWood, topWood to add a guitar
* and  to create a new guitar instance
* and adds to Rick inventory.
*
*/
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    guitars.add(guitar);
  }
/**
* getGuitar takes a guitar's serialNumber
* @return that guitar object
*
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
*Search by Guitar using Guitar object with parameter(builder,model,type,backWood and topWood) 
* the values must be first passed into guitar class and get the guitar object first
* @param search for specific type of guitar
* @returns guitar from Rick's collection Inventory or null 
*/ 
  
  public Guitar search(Guitar searchGuitar) {
//hasNext returns true if it has more guitars elements to iterate
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
//It returns the next element of the list 
	 // @exception- if there is no next element in the list ,It throws ‘NoSuchElementException’ 
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
/** Returns the name of the manufacturer
	  and stores in the string builder
*/
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitar.getManufacturer())))//It compares  manufacturer name with no case sensitivity
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitar.getModel())))//It compares model without case sensitivity
        continue;
      String type = searchGuitar.getType();
      if ((type != null) && (!searchGuitar.equals("")) &&
          (!type.equals(guitar.getType())))//It compares the type without the case sensitivity
        continue;
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equals(guitar.getBackWood())))//It compares the backwood ignoring  case
        continue;
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equals(guitar.getTopWood())))//it compares the the topwood ignoring the case
        continue;
      return guitar;
    }
    return null;
  }
}
