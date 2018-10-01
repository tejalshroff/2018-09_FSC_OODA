/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW2.test.edu.fitchburgstate.csc7400;

import static org.junit.jupiter.api.Assertions.*;

import HW2.edu.fitchburgstate.csc7400.GuitarSpec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import HW2.edu.fitchburgstate.csc7400.Guitar;

/**
 * Test methods for Guitar class
 *
 * @author Tejal Shroff
 */
public class GuitarTest {
    Guitar testGuitar;
    GuitarSpec gSpec = new GuitarSpec();

    /**
     * Initializing the guitar object with some default value
     *
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        this.testGuitar = new Guitar(
                "AB123", // serial number
                203.35, // store price
                GuitarSpec.Manufacturer.gibson, // Manufacturer
                "EasyLearn", // Manufacturer model
                GuitarSpec.Type.electric, // Type of Guitar
                GuitarSpec.BackwoodOrTopwood.maple, // Back wood
                GuitarSpec.BackwoodOrTopwood.adirondack // Face wood
        );
        //	gSpec.match(this.testGuitar.gSpec);
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
        GuitarSpec.Manufacturer returned = this.testGuitar.gSpec.getManufacturer();
        assertEquals(GuitarSpec.Manufacturer.gibson, returned, String.format("Manufacturer %s != %s", GuitarSpec.Manufacturer.gibson, returned));
    }

    /**
     * Test case for mocking Model data
     */
    @Test
    void testGetModel() {
        String expected = "easylearn";
        String returned = this.testGuitar.gSpec.getModel();
        assertEquals(expected, returned, String.format("Model %s != %s", expected, returned));
    }

    /**
     * Test case for mocking Type data
     */
    @Test
    void testGetType() {
        GuitarSpec.Type returned = this.testGuitar.gSpec.getType();
        assertEquals(GuitarSpec.Type.electric, returned, String.format("Type %s != %s", GuitarSpec.Type.electric, returned));
    }

    /**
     * Test case for mocking Back wood data
     */
    @Test
    void testGetBackWood() {
        GuitarSpec.BackwoodOrTopwood returned = this.testGuitar.gSpec.getBackWood();
        assertEquals(GuitarSpec.BackwoodOrTopwood.maple, returned,
                String.format("Back wood %s != %s", GuitarSpec.BackwoodOrTopwood.maple, returned));
    }

    /**
     * Test case for mocking top wood data
     */
    @Test
    void testGetTopWood() {
        GuitarSpec.BackwoodOrTopwood returned = this.testGuitar.gSpec.getTopWood();
        assertEquals(GuitarSpec.BackwoodOrTopwood.adirondack, returned, String.format("Top wood %s != %s",
                GuitarSpec.BackwoodOrTopwood.adirondack, returned));
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
}