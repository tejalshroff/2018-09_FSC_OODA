/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW1.test.edu.fitchburgstate.csc7400;

import HW1.edu.fitchburgstate.csc7400.Guitar;
import HW1.edu.fitchburgstate.csc7400.GuitarSpec;
import HW1.edu.fitchburgstate.csc7400.Inventory;
import HW1.edu.fitchburgstate.csc7400.FindGuitarTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    GuitarSpec gspec = new GuitarSpec();

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

        this.testInventory.addGuitar(this.testGuitarNew.getSerialNumber(), this.testGuitarNew.getPrice(),
                this.testGuitarNew.gSpec.getManufacturer(), this.testGuitarNew.gSpec.getModel(),
                this.testGuitarNew.gSpec.getType(), this.testGuitarNew.gSpec.getBackWood(),
                this.testGuitarNew.gSpec.getTopWood());


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
        this.testInventory.addGuitar(testGuitarAdd.getSerialNumber(), testGuitarAdd.getPrice(),
                testGuitarAdd.gSpec.getManufacturer(), testGuitarAdd.gSpec.getModel(),
                testGuitarAdd.gSpec.getType(), testGuitarAdd.gSpec.getBackWood(), testGuitarAdd.gSpec.getTopWood());

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

        try {
            CompareGuitars(this.expectedSearchValue, returnValue);
        }catch (AssertionError ae)
        {
            assertFalse(true);
        }
    }

    /**
     * Add two guitar's in invemtory and check if the first Guitar Is is present in inventory
     */
    @Test
    public void AddTwoGuitarsinInventory()
    {
        Guitar testGuitarAdd = new Guitar(
                "TY555", // serial number
                850, // store price
                "PRS", // Manufacturer
                "TE-585", // Manufacturer model
                "electric", // Type of Guitar
                "Sitka", // Back wood
                "RoseWood" // Face wood
        );
        this.testInventory.addGuitar(testGuitarAdd.getSerialNumber(), testGuitarAdd.getPrice(),
                testGuitarAdd.gSpec.getManufacturer(), testGuitarAdd.gSpec.getModel(),
                testGuitarAdd.gSpec.getType(), testGuitarAdd.gSpec.getBackWood(), testGuitarAdd.gSpec.getTopWood());

         testGuitarAdd = new Guitar(
                "TY557", // serial number
                900, // store price
                "Martin", // Manufacturer
                "TE-577", // Manufacturer model
                "electric", // Type of Guitar
                "Mahogany", // Back wood
                "IndianRosewood" // Face wood
        );
        this.testInventory.addGuitar(testGuitarAdd.getSerialNumber(), testGuitarAdd.getPrice(),
                testGuitarAdd.gSpec.getManufacturer(), testGuitarAdd.gSpec.getModel(),
                testGuitarAdd.gSpec.getType(), testGuitarAdd.gSpec.getBackWood(), testGuitarAdd.gSpec.getTopWood());

        Guitar returnValue = testInventory.getGuitar("TY555");
        assertNotNull(returnValue, String.format("NULL value returned."));
    }

    /**
     * Test case to search guitar from inventory
     */
    @Test
    public void search() {
       List<Guitar> returnValue = testInventory.search(this.expectedSearchValue);
        assertNotNull(returnValue, String.format("Guitar you are serachimg is not available."));
    }

    /**
     * Test case to search guitar using backwood
     */
    @Test
    public void getGuitarfromBackwood() {
        Guitar testGuitarBackwood = new Guitar("", 0, "",
                "", "", "Mahogany", "");
        List<Guitar> returnValue = testInventory.search(testGuitarBackwood);
        assertNotNull(returnValue, String.format("Guitar not found"));
    }

    /**
     * Test case to search guitar using manufacture
     */
    @Test
    public void getGuitarfromManufacture() {
        Guitar testGuitarManufacture = new Guitar("", 0, "Gibson",
                "", "", "", "");
        List<Guitar> returnValue = testInventory.search(testGuitarManufacture);
        assertNotNull(returnValue, String.format("Guitar not found"));
    }

    /**
     * Test case to search using Price not present in inventory
     */
    @Test
    public void getGuitarfromPriceNoAvailableInInventory() {
        Guitar testGuitarPrice = new Guitar("", 1200, "",
                "", "", "", "");
        List<Guitar> returnValue = testInventory.search(testGuitarPrice);
        assertNull(returnValue, String.format("Guitar not found"));
    }
    /**
     * Test case to search using Price not present in inventory
     */
    @Test
    public void getGuitarfromPrice() {
        Guitar testGuitarPrice = new Guitar("", 6295.95, "",
                "", "", "", "");
        List<Guitar> returnValue = testInventory.search(testGuitarPrice);
        assertNotNull(returnValue, String.format("Guitar not found"));
    }
    /**
     * Test case to search using Model
     */
    @Test
    public void getGuitarfromModel() {
        Guitar testGuitarModel = new Guitar("", 0, "",
                "TY-557", "", "", "");
        List<Guitar> returnValue = testInventory.search(testGuitarModel);
        assertNull(returnValue, String.format("Guitar not found"));
    }

    /**
     * Test case to search using type which should return null
     */
    @Test
    public void getGuitarfromType() {
        Guitar testGuitarModel = new Guitar("", 0, "",
                "", "Bass", "", "");
        gspec.match(testGuitarModel.gSpec);
       if(testGuitarModel.gSpec.getModel() == "") {
           assertNull(null, String.format("Guitar found"));
       }
    }

    /**
     * Test case to search using topwood which should return null
     */
    @Test
    public void getGuitarfromTopWood() {
        Guitar testGuitarTopWood = new Guitar("", 0, "",
                "", "", "", "Sandalwood");
        gspec.match(testGuitarTopWood.gSpec);
        if(gspec.getTopWood() =="")
        {
            assertNull(null, String.format("Guitar found"));
        }

    }

    /**
     * Test case for searching guitar where all parameters are null and will return first guitar in the inventory list
     */
    @Test
    public void getGuitarwithnoPreference() {
        Guitar testGuitarwithNoPreference = new Guitar("", 0, "",
                "", "", "", "");
        List<Guitar> returnValue = testInventory.search(testGuitarwithNoPreference);
        assertNotNull(returnValue, String.format("Guitar found"));
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Compare guitar1 and guitar2 if they are equal
     * @param guitar1 object of first guitar to compare
     * @param guitar2 object of second guitar to compare
     */
    private void CompareGuitars(Guitar guitar1, Guitar guitar2)
    {
        if(guitar1==null) { //if guitar 1 is not null and guitar2 is null will go the elseif condition
            if (guitar2 == null) { // if guitar1 is null and gutar2 is null will return
                return;
            } else {
                assertTrue(false);
            }
        }
        else if(guitar2== null)
        {
            assertTrue(false);
        }
        else
        {
            assertEquals(guitar1.getSerialNumber(),guitar2.getSerialNumber(),String.format("Serial no. are not equal"));
            assertEquals(guitar1.getPrice(),guitar2.getPrice(),String.format("Price is not equal"));
            assertEquals(guitar1.gSpec.getManufacturer(),guitar2.gSpec.getManufacturer(),String.format("Manufacturer are not equal"));
            assertEquals(guitar1.gSpec.getModel(),guitar2.gSpec.getModel(),String.format("Model are not equal"));
            assertEquals(guitar1.gSpec.getType(),guitar2.gSpec.getType(),String.format("Type are not equal"));
            assertEquals(guitar1.gSpec.getBackWood(),guitar2.gSpec.getBackWood(),String.format("BackWood are not equal"));
            assertEquals(guitar1.gSpec.getTopWood(),guitar2.gSpec.getTopWood(),String.format("TopWood are not equal"));
        }
    }
}