/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW1.test.edu.fitchburgstate.csc7400;

import HW1.edu.fitchburgstate.csc7400.Guitar;
import HW1.edu.fitchburgstate.csc7400.Inventory;
import HW1.edu.fitchburgstate.csc7400.FindGuitarTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test methods for Inventory class
 *
 * @author Tejal Shroff
 */
public class InventoryTest {
    Guitar testGuitarNew, expectedSearchValue;
    Inventory testInventory = new Inventory();
    FindGuitarTester testFindGuitar = new FindGuitarTester();

    /**
     * This method will be executed before every test method and will initialize all the object of
     * Guitar class , Inventory call and FindGuitarTester class
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testFindGuitar.initializeInventory(testInventory);

        this.testGuitarNew = new Guitar(
                "TN152", // serial number
                503.35, // store price
                "Gibson", // Manufacturer
                "D-456", // Manufacturer model
                "acoustic", // Type of Guitar
                "Mahogany", // Back wood
                "Adirondack" // Face wood
        );
      /* this.testInventory.addGuitar(this.testGuitarNew.getSerialNumber(), this.testGuitarNew.getPrice(), this.testGuitarNew.getManufacturer(),
                this.testGuitarNew.getModel(), this.testGuitarNew.getType(), this.testGuitarNew.getBackWood(), this.testGuitarNew.getTopWood());
       */

        this.expectedSearchValue = new Guitar(
                "V95693",
                1499.95,
                "fender",
                "stratocastor",
                "electric",
                "alder",
                "alder"
        );
    }


    /**
     * Test case to add guitar to inventory
     */
    @Test
    public void addGuitar() {
        //Add guitar to inventory
        Guitar testGuitarAdd = new Guitar(
                "SP152", // serial number
                450, // store price
                "Fender", // Manufacturer
                "TE-456", // Manufacturer model
                "electric", // Type of Guitar
                "Mahogany", // Back wood
                "RoseWood" // Face wood
        );
       /* this.testInventory.addGuitar(testGuitarAdd.getSerialNumber(), testGuitarAdd.getPrice(), testGuitarAdd.getManufacturer(),
                testGuitarAdd.getModel(), testGuitarAdd.getType(), testGuitarAdd.getBackWood(), testGuitarAdd.getTopWood());
        */
        // If added properly get will return the added guitar
        Guitar returnValue = testInventory.getGuitar(testGuitarAdd.getSerialNumber());
        assertNotNull(returnValue, String.format("Guitar not added to list"));
    }

    /**
     * Test case to get a guitar from inventory using serial number
     */
    @Test
    public void getGuitar() {
        Guitar returnValue = testInventory.getGuitar(this.expectedSearchValue.getSerialNumber());
        assertNotNull(returnValue, String.format("NULL value returned."));
    }

    /**
     * Test case to search guitar from inventory
     */
    @Test
    public void search() {
       // Guitar returnValue = testInventory.search(this.expectedSearchValue);
        //assertNotNull(returnValue, String.format("Guitar you are serachimg is not available."));
    }

    /**
     * Test case to search guitar using backwood
     */
    @Test
    public void getGuitarfromBackwood() {
        Guitar testGuitarBackwood = new Guitar("", 0, "",
                "", "", "Mahogany", "");
        //Guitar returnValue = testInventory.search(testGuitarBackwood);
        //assertNotNull(returnValue, String.format("Guitar not found"));
    }

    /**
     * Test case to search guitar using manufacture
     */
    @Test
    public void getGuitarfromManufacture() {
        Guitar testGuitarManufacture = new Guitar("", 0, "Gibson",
                "", "", "", "");
       // Guitar returnValue = testInventory.search(testGuitarManufacture);
        //assertNotNull(returnValue, String.format("Guitar not found"));
    }

    /**
     * Test case to search using Price
     */
    @Test
    public void getGuitarfromPrice(){
        Guitar testGuitarPrice = new Guitar("", 1200, "",
                "", "", "", "");
       // Guitar returnValue = testInventory.search(testGuitarPrice);
        //assertNotNull(returnValue, String.format("Guitar not found"));
    }

    /**
     * Test case to search using Price
     */
    @Test
    public void getGuitarfromModel(){
        Guitar testGuitarModel = new Guitar("", 0, "",
                "", "", "", "");
       // Guitar returnValue = testInventory.search(testGuitarModel);
       // assertNotNull(returnValue, String.format("Guitar not found"));
    }

    /**
     * Test case to search using type which should return null
     */
    @Test
    public void getGuitarfromType(){
        Guitar testGuitarModel = new Guitar("", 0, "",
                "", "Bass", "", "");
        //Guitar returnValue = testInventory.search(testGuitarModel);
      //  assertNull(returnValue, String.format("Guitar found"));
    }

    /**
     * Test case to search using topwood which should return null
     */
    @Test
    public void getGuitarfromTopWood(){
        Guitar testGuitarTopWood = new Guitar("", 0, "",
                "", "", "", "Sandalwood");
        //Guitar returnValue = testInventory.search(testGuitarTopWood);
       // assertNull(returnValue, String.format("Guitar found"));
    }

    /**
     * Test case for searching guitar where all parameters are null and will return first guitar in the inventory list
     */
    @Test
    public void getGuitarwithnoPreference(){
        Guitar testGuitarwithNoPreference = new Guitar("", 0, "",
                "", "", "", "");
        //Guitar returnValue = testInventory.search(testGuitarwithNoPreference);
        //assertNotNull(returnValue, String.format("Guitar found"));
    }
    @After
    public void tearDown() throws Exception {
    }
}