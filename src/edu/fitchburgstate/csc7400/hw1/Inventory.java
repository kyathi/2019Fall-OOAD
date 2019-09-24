package edu.fitchburgstate.csc7400.hw1;

/*
 *	Class: Object Oriented Analysis and Design
 *	Instructor: Orlando Montalvo
 *	Assignment: Homework 1
 *	Student Name: Rick Phillips
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author rphillips
 *
 */
public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }

/**
 * Invoke the new guitar constructor and add to
 * our collection
 * 
 * @param serialNumber - unique identifier
 * @param price - item cost
 * @param builder - item manufacturer
 * @param model - item model
 * @param type - item type
 * @param backWood - item back wood
 * @param topWood - item top wood
 */
public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
	  
    Guitar guitar = new Guitar(serialNumber, price, builder,
                               model, type, backWood, topWood);
    
    guitars.add(guitar);
    
  }

 /**
 * @param serialNumber to search against the collection of guitars
 * @return guitar with the provided serial number or null if none
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
 * @param searchGuitar - object to compare with our collection
 * @return - first guitar found or null if none
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
