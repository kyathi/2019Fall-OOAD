package edu.fitchburgstate.csc7400.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Inventory class properties.
 *
 * @author Nodir.Nabiev
 * Date: 2019-09-18
 */
class InventoryTest {
	Inventory inventory;

	/**
	 * Set up guitar inventory before test.
	 *
	 * @throws Exception exception
	 */
	@BeforeEach
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
	 * Clean up inventory after each test.
	 *
	 * @throws Exception exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		inventory = null;
	}

	/**
	 * Search the specified guitar from the inventory.
	 *
	 * @result Finds the requested guitar from the inventory, if null, no matched guitar found
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
			fail("Did not find guitar");
		}
	}

}
