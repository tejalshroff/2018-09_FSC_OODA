/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW1.edu.fitchburgstate.csc7400;

/**
 * Contains attributes of Guitar (enum)
 * Match method searches for a particular guitar and returns true if found or false if not found
 *
 * @author Tejal Shroff
 */
public class GuitarSpec {
    public GuitarSpec() {
    }

    public GuitarSpec(String manufacturer, String model,
                      String type, String backWood,
                      String topWood) {

        this.model = model.toLowerCase();
        this.manufacturer = manufacturer.toLowerCase();
        this.type = type.toLowerCase();
        this.backWood = backWood.toLowerCase();
        this.topWood = topWood.toLowerCase();
    }

    /**
     * Type of back wood and face/top wood for guitar
     */
    enum BackwoodOrTopwood {
        IndianRosewood, BrazilianRosewood, Mahogany, Maple, Cocobolo, Cedar, Adirondack, Alder, Sitka;
    }

    /**
     * Type of Guitar
     */
    enum Type {
        Electric, Acoustic;
    }

    /**
     * Different manufacturer of guitar
     */
    enum Manufacturer {
        Fender, Martin, Gibson, Collings, Olson, Ryan, PRS;
    }


    /**
     * The guitar type (electric/acoustic)
     */
    private String type;

    /**
     * The wood used for the back of the guitar
     */
    private String backWood;

    /**
     * The wood used for the face of the guitar
     */
    private String topWood;

    /**
     * The name of the manufacturer
     */
    private String manufacturer;

    /**
     * The manufacturer model number
     */
    private String model;

    /**
     * Returns the name of the manufacturer
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * Returns the manufacturer model
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the guitar type
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the type of wood used in the body
     */
    public String getBackWood() {
        return backWood;
    }

    /**
     * Returns the type of wood used in the face
     *
     * @return
     */
    public String getTopWood() {
        return topWood;
    }


    /**
     * Matches the current guitar spec spefied by user to the guitar spec available in the enum
     * For every attribute user has specified will be checked in enum
     * (enum has all the constant values for the guitar categories)
     *
     * @param gSpec object of guitar spec class
     */
    public void match(GuitarSpec gSpec) {

        this.model = gSpec.model;
        switch (gSpec.backWood.toLowerCase()) {
            case "indianrosewood":
            case "brazilianrosewood":
            case "mahogany":
            case "maple":
            case "cocobolo":
            case "cedar":
            case "adirondack":
            case "alder":
            case "sitka":
                this.backWood = gSpec.backWood;
                break;
            default:
                this.backWood = "";
                break;
        }

        switch (gSpec.topWood.toLowerCase()) {
            case "indianrosewood":
            case "brazilianrosewood":
            case "mahogany":
            case "maple":
            case "cocobolo":
            case "cedar":
            case "adirondack":
            case "alder":
            case "sitka":
                this.topWood = gSpec.topWood;
                break;
            default:
                this.topWood = "";
                break;
        }

        switch (gSpec.type.toLowerCase()) {
            case "electric":
            case "acoustic":
                this.type = gSpec.type;
                break;
            default:
                this.type = "";
                break;
        }

        switch (gSpec.manufacturer.toLowerCase()) {
            case "fender":
            case "martin":
            case "gibson":
            case "collings":
            case "olson":
            case "ryan":
            case "prs":
                this.manufacturer = gSpec.manufacturer;
                break;
            default:
                this.manufacturer = "";
                break;
        }
    }

}

