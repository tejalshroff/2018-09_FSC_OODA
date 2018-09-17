/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW1.edu.fitchburgstate.csc7400;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import  HW1.edu.fitchburgstate.csc7400.Guitar;

/**
 * Inventory keeps a searchable collection of Guitars. It is meant to be use
 * to find matching guitars for customers.
 *
 * @author Tejal Shroff
 */

public class Inventory {
  private List<Guitar> guitars = new LinkedList<Guitar>();

  /**
   * Adds guitar details to list
   * @param serialNumber manufacturer serial number
   * @param price store price
   * @param builder the guitar's manufacturer
   * @param model the manufacturers model
   * @param type guitar type (electric/accoustic)
   * @param backWood the wood used for the guitar body
   * @param topWood the wood used for the guitar's face
   */
  public void addGuitar(String serialNumber, double price,
                        String builder, String model,
                        String type, String backWood, String topWood) {
    Guitar guitar = new Guitar(serialNumber, price, builder.toLowerCase(),
            model.toLowerCase(), type.toLowerCase(), backWood.toLowerCase(), topWood.toLowerCase());
    guitars.add(guitar);
  }

  /**
   * Returns detail information of guitar for a particular serial number
   * @param serialNumber unique number assigned to every guitar
   * @return
   */
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  /**
   * Search guitar in inventory with guitar description provided by customer
   * @param searchGuitar Guitar object
   * @return Details for searched guitar else returns null if guitar not found
   */
  public Guitar search(Guitar searchGuitar) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      String builder = searchGuitar.getManufacturer();
      if ((builder != null) && (!builder.equals("")) &&
              (!builder.equals(guitar.getManufacturer())))
        continue;
      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) &&
              (!model.equals(guitar.getModel())))
        continue;
      String type = searchGuitar.getType();
      if ((type != null) && (!type.equals("")) &&
              (!type.equals(guitar.getType())))
        continue;
      String backWood = searchGuitar.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
              (!backWood.equals(guitar.getBackWood())))
        continue;
      String topWood = searchGuitar.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
              (!topWood.equals(guitar.getTopWood())))
        continue;
      return guitar;
    }
    return null;
  }
}
