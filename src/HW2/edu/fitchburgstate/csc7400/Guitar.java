/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW2.edu.fitchburgstate.csc7400;

/**
 * Guitar contains the information needed to keep track of a type of guitar from
 * Rick's music store
 * All getter setter of guitar attributes are initialized
 * @author Tejal Shroff
 */


public class Guitar {

    /**
     * Full constructor
     * @param serialNumber manufacturer serial number
     * @param price        store price
     * @param manufacturer the guitar's manufacturer enum
     * @param model        the manufacturers model
     * @param type         guitar type (electric/accoustic) enum
     * @param backwood     the wood used for the guitar body enum
     * @param topwood      the wood used for the guitar's face enum
     */
    public Guitar(String serialNumber, double price,GuitarSpec.Manufacturer manufacturer, String model ,GuitarSpec.Type type,
                  GuitarSpec.BackwoodOrTopwood backwood ,GuitarSpec.BackwoodOrTopwood topwood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.gSpec = new GuitarSpec(manufacturer,model,type,backwood,topwood);
    }

    /**
     * Returns the manufacturer serial number
     * <p>
     * NB: Gets and sets do not need @params or @returns because they do one thing which
     * is already in the comment
     */
    public String getSerialNumber() {
        return serialNumber;
    }


    /**
     * Returns store price of guitar
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the store price of the guitar
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * The guitars manufacturer serial number
     */
    private String serialNumber;

    /**
     * Rick's price for the guitar
     */
    private double price;

    /***
     * Object instantiation for Guitar spec class
     */
    public GuitarSpec gSpec;
}