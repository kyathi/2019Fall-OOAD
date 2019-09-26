/*
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-25
 * Authors: HeadFirstOODA, parkerrobc
 */

package edu.fitchburgstate.csc7400.hw1;

/**
 * Guitar contains the information about a guitar
 * 
 * @author HeadFirstOODA
 * @author parkerrobc
 */
public class Guitar {

	/**
	 * The serial number
	 */
	private String serialNumber;

	/**
	 * The manufacturer
	 */
	private String manufacturer;

	/**
	 * The model number
	 */
	private String model;

	/**
	 * The guitar type electric/acoustic (not enforced)
	 */
	private String type;

	/**
	 * The wood used for the guitar body
	 */
	private String backWood;

	/**
	 * The wood used for the guitar's face
	 */
	private String topWood;

	/**
	 * Price for the guitar
	 */
	private double price;

	/**
	 * Constructor for the guitar
	 * 
	 * @param serialNumber the serial number
	 * @param price the price
	 * @param manufacturer the manufacturer
	 * @param model the model
	 * @param type guitar type electric/acoustic (not enforced)
	 * @param backWood the wood used for the guitar body
	 * @param topWood the wood used for the guitar's face
	 */
	public Guitar(String serialNumber, double price, String manufacturer, String model, String type, String backWood,
			String topWood) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.manufacturer = manufacturer;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}

	/**
	 * Sets the price
	 */
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}

	/**
	 * Returns the serial number
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Returns the manufacturer
	 */
	public String getManufacturer() {
		return this.manufacturer;
	}

	/**
	 * Returns the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Returns the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the wood used for the back of the guitar
	 */
	public String getBackWood() {
		return backWood;
	}

	/**
	 * Returns the wood used for the guitar's face
	 */
	public String getTopWood() {
		return topWood;
	}

	/**
	 * Returns the price
	 */
	public double getPrice() {
		return price;
	}

}
