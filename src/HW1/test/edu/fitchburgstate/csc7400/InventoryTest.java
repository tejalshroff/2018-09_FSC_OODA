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
import  HW1.edu.fitchburgstate.csc7400.FindGuitarTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InventoryTest {
    Guitar testGuitarNew,expectedSearchValue;
    Inventory testInventory = new Inventory();
    FindGuitarTester testFindGuitar = new FindGuitarTester();

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


    @Test
    public void addGuitar() {
        //Add guitar to inventory
        this.testInventory.addGuitar(this.testGuitarNew.getSerialNumber(),this.testGuitarNew.getPrice(),this.testGuitarNew.getManufacturer(),
                this.testGuitarNew.getModel(),this.testGuitarNew.getType(),this.testGuitarNew.getBackWood(),this.testGuitarNew.getTopWood());
        // If added properly get will return the added guitar
        Guitar returnValue = testInventory.getGuitar(this.testGuitarNew.getSerialNumber());
        assertNotNull(returnValue,String.format("Guitar not added to list"));
    }

    @Test
    public void getGuitar() {
        Guitar returnValue = testInventory.getGuitar(this.expectedSearchValue.getSerialNumber());
        assertNotNull(returnValue,String.format("NULL value returned."));
    }

    @Test
    public void search() {
        Guitar returnValue= testInventory.search(this.expectedSearchValue);
        assertNotNull(returnValue,String.format("Guitar you are serachimg is not available."));
    }

    @After
    public void tearDown() throws Exception {
    }
}