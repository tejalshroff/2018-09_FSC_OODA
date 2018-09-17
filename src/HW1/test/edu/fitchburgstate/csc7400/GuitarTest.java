/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW1.test.edu.fitchburgstate.csc7400;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import HW1.edu.fitchburgstate.csc7400.Guitar;

/**
 * Test methods for Guitar class
 * @author Tejal Shroff
 */
public class GuitarTest {
	Guitar testGuitar;

	/**
	 * Initializing the guitar object with some default value
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.testGuitar = new Guitar(
				"AB123", // serial number
				203.35, // store price
				"Gibson", // Manufacturer
				"EasyLearn", // Manufacturer model
				"electric", // Type of Guitar
				"Maple", // Back wood
				"Adirondack" // Face wood
		);
	}

	/**
	 * Test case for mocking serial number data
	 */
	@Test
	void testGetSerialNumber() {
		String expected = "AB123";
		String returned = this.testGuitar.getSerialNumber();
		assertEquals(expected, returned, String.format("Serial number %s != %s", expected, returned));
	}

	/**
	 * Test case for mocking price data
	 */
	@Test
	void testGetPrice() {
		double expected = 203.35;
		double returned = this.testGuitar.getPrice();
		assertEquals(expected, returned, 0.01, String.format("Price %f != %f", expected, returned));
	}

	/**
	 * Test case for setting and getting price data
	 */
	@Test
	void testSetPrice() {
		double expected = 225.10;
		this.testGuitar.setPrice(expected);
		double returned = this.testGuitar.getPrice();
		assertEquals(expected, returned, String.format("Price %f != %f", expected, returned));
	}

	/**
	 * Test case for mocking manufacture data
	 */
	@Test
	void testGetManufacturer() {
		String expected = "Gibson";
		//String returned = this.testGuitar.getManufacturer();
		//assertEquals(expected, returned, String.format("Manufacturer %s != %s", expected, returned));
	}

	/**
	 * Test case for mocking Model data
	 */
	@Test
	void testGetModel() {
		String expected = "EasyLearn";
		//String returned = this.testGuitar.getModel();
		//assertEquals(expected, returned, String.format("Model %s != %s", expected, returned));
	}

	/**
	 * Test case for mocking Type data
	 */
	@Test
	void testGetType() {
		String expected = "electric";
		//String returned = this.testGuitar.getType();
		//assertEquals(expected, returned, String.format("Type %s != %s", expected, returned));
	}

	/**
	 * Test case for mocking Back wood data
	 */
	@Test
	void testGetBackWood() {
		String expected = "Maple";
		//String returned = this.testGuitar.getBackWood();
		//assertEquals(expected, returned, String.format("Back wood %s != %s", expected, returned));
	}

	/**
	 * Test case for mocking top wood data
	 */
	@Test
	void testGetTopWood() {
		String expected = "Adirondack";
		//String returned = this.testGuitar.getTopWood();
		//assertEquals(expected, returned, String.format("Top wood %s != %s", expected, returned));
	}

	@org.junit.After
	public void tearDown() throws Exception {
	}
}