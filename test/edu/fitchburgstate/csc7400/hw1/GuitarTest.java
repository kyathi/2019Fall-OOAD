/* * Class: Object-Oriented Analysis and Design 
 * * Professor: Orlando Montalvo 
 * * Assignment: HW 1 * 
 * Date: 2019-01-01 
 * * Authors: Orlando Montalvo (omontalv) 
 * Student: Vinitha Gaddampally*/

package edu.fitchburgstate.csc7400.hw1;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GuitarTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void getSerialNumber() {
	
		//Testing get serial number
		
		Guitar guitarForVinitha = new Guitar("00001", 0, "fender", "Stratocastor", "electric", "Alder", "Alder");
		var serialNumber = guitarForVinitha.getSerialNumber();
		assertEquals("00001",serialNumber);
	}

}
