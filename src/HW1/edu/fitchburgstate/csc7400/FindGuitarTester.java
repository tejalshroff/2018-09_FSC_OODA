/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW1.edu.fitchburgstate.csc7400;

import java.util.Iterator;
import java.util.List;

/**
 * FindGuitarTester class drives the project where Erin can search his guitar
 * and keep detail information of guitar inventory
 *
 * @author Tejal Shroff
 */

public class FindGuitarTester {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        initializeInventory(inventory);
        Guitar whatErinLikes = new Guitar("", 0, GuitarSpec.Manufacturer.fender, "Stratocastor",
                GuitarSpec.Type.electric,GuitarSpec.BackwoodOrTopwood.alder , GuitarSpec.BackwoodOrTopwood.alder);
        List<Guitar> guitarList = inventory.search(whatErinLikes);
        if (guitarList != null) {
            System.out.println("Erin, you might like this " );
            for (Iterator i = guitarList.iterator(); i.hasNext(); ) {
                Guitar guitar = (Guitar) i.next();
                System.out.println(
                        guitar.gSpec.getManufacturer() + " " + guitar.gSpec.getModel() + " " +
                        guitar.gSpec.getType() + " guitar:\n   " +
                        guitar.gSpec.getBackWood() + " back and sides,\n   " +
                        guitar.gSpec.getTopWood() + " top.\nYou can have it for only $" +
                        guitar.getPrice() + "!\n");
            }

        } else {
            System.out.println("Sorry, Erin, we have nothing for you.");
        }
    }

    /**
     * Add guitar details to inventory
     *
     * @param inventory object of inventory class
     */
    public static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("11277", 3999.95, GuitarSpec.Manufacturer.collings,"CJ", GuitarSpec.Type.acoustic,
                GuitarSpec.BackwoodOrTopwood.indianrosewood, GuitarSpec.BackwoodOrTopwood.sitka);
        inventory.addGuitar("V95693", 1499.95, GuitarSpec.Manufacturer.fender, "Stratocastor", GuitarSpec.Type.electric,
                GuitarSpec.BackwoodOrTopwood.alder, GuitarSpec.BackwoodOrTopwood.alder);
        inventory.addGuitar("V9512", 1549.95, GuitarSpec.Manufacturer.fender, "Stratocastor", GuitarSpec.Type.electric,
                GuitarSpec.BackwoodOrTopwood.alder, GuitarSpec.BackwoodOrTopwood.alder);
        inventory.addGuitar("122784", 5495.95, GuitarSpec.Manufacturer.martin, "D-18", GuitarSpec.Type.acoustic,
                GuitarSpec.BackwoodOrTopwood.mahogany, GuitarSpec.BackwoodOrTopwood.adirondack);
        inventory.addGuitar("76531", 6295.95, GuitarSpec.Manufacturer.martin, "OM-28", GuitarSpec.Type.acoustic,
                GuitarSpec.BackwoodOrTopwood.brazilianrosewood, GuitarSpec.BackwoodOrTopwood.adirondack);
        inventory.addGuitar("70108276", 2295.95, GuitarSpec.Manufacturer.gibson, "Les Paul", GuitarSpec.Type.electric,
                GuitarSpec.BackwoodOrTopwood.mahogany, GuitarSpec.BackwoodOrTopwood.maple);
        inventory.addGuitar("82765501", 1890.95, GuitarSpec.Manufacturer.gibson, "SG '61 Reissue",
                GuitarSpec.Type.electric, GuitarSpec.BackwoodOrTopwood.mahogany, GuitarSpec.BackwoodOrTopwood.mahogany);
        inventory.addGuitar("77023", 6275.95, GuitarSpec.Manufacturer.martin, "D-28", GuitarSpec.Type.acoustic,
                GuitarSpec.BackwoodOrTopwood.brazilianrosewood, GuitarSpec.BackwoodOrTopwood.adirondack);
        inventory.addGuitar("1092", 12995.95, GuitarSpec.Manufacturer.olson, "SJ", GuitarSpec.Type.acoustic,
                GuitarSpec.BackwoodOrTopwood.indianrosewood, GuitarSpec.BackwoodOrTopwood.cedar);
        inventory.addGuitar("566-62", 8999.95, GuitarSpec.Manufacturer.ryan,"Cathedral",GuitarSpec.Type.acoustic,
                GuitarSpec.BackwoodOrTopwood.cocobolo, GuitarSpec.BackwoodOrTopwood.cedar);
        inventory.addGuitar("6 29584", 2100.95, GuitarSpec.Manufacturer.prs, "Dave Navarro Signature",
                GuitarSpec.Type.electric,GuitarSpec.BackwoodOrTopwood.mahogany,GuitarSpec.BackwoodOrTopwood.maple);
    }

}
