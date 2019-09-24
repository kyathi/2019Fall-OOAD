
/** Class	   : Object-Oriented Design and Analysis
*   Professor  : Orlando Montalvo
*   Assignment : Home Work 1
*   Student	   : Komal(@01411726)
*   Date	   : 2019-09-24
*/

package edu.fitchburgstate.csc7400.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Inventorytest class contains JUnit Test cases for Inventory class.
 * Currently, it matches customer requirements with the inventory available. 
 * The purpose of inventory test class is to test all the methods present in the inventory class.
 * @author Komal
 * @version 1.0
 */

public class InventoryTest {
	Inventory inventory;

	/**
     * Executes before every test method and adds different guitars to the inventory.
     * @throws Exception
     */
	
	@BeforeEach // A method that executes before the @Test
	void setUp() throws Exception {
		inventory = new Inventory();
		inventory.addGuitar("11277", 3999.95, "Collings", "CJ", "acoustic", "Indian Rosewood", "Sitka");
		inventory.addGuitar("V95693", 1499.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");
		inventory.addGuitar("V9512", 1549.95, "Fender", "Stratocastor", "electric", "Alder", "Alder");
		inventory.addGuitar("122784", 5495.95, "Martin", "D-18", "acoustic", "Mahogany", "Adirondack");
		inventory.addGuitar("76531", 6295.95, "Martin", "OM-28", "acoustic", "Brazilian Rosewood", "Adriondack");
		inventory.addGuitar("70108276", 2295.95, "Gibson", "Les Paul", "electric", "Mahogany", "Maple");
		inventory.addGuitar("82765501", 1890.95, "Gibson", "SG '61 Reissue", "electric", "Mahogany", "Mahogany");
		inventory.addGuitar("77023", 6275.95, "Martin", "D-28", "acoustic", "Brazilian Rosewood", "Adirondack");
		inventory.addGuitar("1092", 12995.95, "Olson", "SJ", "acoustic", "Indian Rosewood", "Cedar");
		inventory.addGuitar("566-62", 8999.95, "Ryan", "Cathedral", "acoustic", "Cocobolo", "Cedar");
		inventory.addGuitar("6 29584", 2100.95, "PRS", "Dave Navarro Signature", "electric", "Mahogany", "Maple");
	}

	/**
     * Executes before every test method and makes inventory NULL.
     * @throws Exception
     */
	
	@AfterEach // Executes before the @Test
	void tearDown() throws Exception {
		inventory = null;
	}

	
	/**
	 * testSearch method will test the inventory by passing guitar with all arguments. 
	 * And Pass the test case if a match is found and fail if no match found.
	 */
		
	@Test
	void testSearch() {
		Guitar whatErinLikes = new Guitar("", 0, "fender", "Stratocastor", "electric", "Alder", "Alder");
		
		Guitar guitar = inventory.search(whatErinLikes);
		if (guitar != null) {
			System.out.println("Erin, you might like this " + guitar.getManufacturer() + " " + guitar.getModel() + " "
					+ guitar.getType() + " guitar:\n   " + guitar.getBackWood() + " back and sides,\n   "
					+ guitar.getTopWood() + " top.\nYou can have it for only $" + guitar.getPrice() + "!");
		} else {
			System.out.println("Sorry, Erin, we have nothing for you.");
			fail("Did not find guitar");// whatErinLikes does not match the inventory list items, hence test case fails.
		}
	}
	/** 
	 * Let's suppose Guitar whatErinLikes = new Guitar("1092", 12995.95, "Olson", "SJ", "acoustic", "Indian Rosewood", "Cedar");
	 * then test case will pass and the details of the guitar available will be displayed as output. 
	 */

}
