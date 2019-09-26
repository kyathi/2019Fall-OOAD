package edu.fitchburgstate.csc7400.hw1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Inventory contains information of a list of guitars 
 * To do: Inventory contains information of a list of a generic item.
 * @author xia.jin
 *
 */
public class Inventory {
	/**
	 *  A list of guitars that have been added into the inventory
	 */
	private List<Guitar> guitars;

	/**
	 * Constructor
	 * Initializes with an empty list
	 */
	public Inventory() {
		guitars = new LinkedList<Guitar>();
	}

	/**
	 * Adds a guitar into the list
	 * @param serialNumber manufacturer serial number
	 * @param price store price
	 * @param manufacturer the guitar's manufacturer
	 * @param model the manufacturers model
	 * @param type guitar type (electric/accoustic)
	 * @param backWood the wood used for the guitar body
	 * @param topWood the wood used for the guitar's face
	 */
	public void addGuitar(String serialNumber, double price,
			String manufacturer, String model,
			String type, String backWood, String topWood) {
		Guitar guitar = new Guitar(serialNumber, price, manufacturer,
				model, type, backWood, topWood);
		guitars.add(guitar);
	}
	
	/**
	 * Finds a guitar using a manufacturer serial number
	 * Returns null if no guitar is found
	 * @param serialNumber manufacturer serial number
	 * @return a guitar that matches the serial number, or null if no match
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
	 * Finds the first guitar that matches search guitar
	 * @param searchGuitar a guitar that you would like to search based on
	 * 		manufacturer, model, type, backwood, and topwood
	 * @return a guitar that matches, or null if no match
	 */
	public Guitar search(Guitar searchGuitar) {
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
			Guitar guitar = (Guitar)i.next();
			// Ignore serial number since that's unique
			// Ignore price since that's unique
			String manufacturer = searchGuitar.getManufacturer();
			if ((manufacturer != null) && (!manufacturer.equals("")) &&
					(!manufacturer.toLowerCase().equals(guitar.getManufacturer().toLowerCase())))
				continue;
			String model = searchGuitar.getModel();
			if ((model != null) && (!model.equals("")) &&
					(!model.toLowerCase().equals(guitar.getModel().toLowerCase())))
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
