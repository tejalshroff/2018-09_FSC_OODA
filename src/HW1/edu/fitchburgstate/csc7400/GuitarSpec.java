/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW1.edu.fitchburgstate.csc7400;

import com.sun.deploy.security.ValidationState;

/**
 * Contains attributes of Guitar (enum)
 * Match method matches the enum value and the user value.
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
        indianrosewood, brazilianrosewood, mahogany, maple, cocobolo, cedar, adirondack, alder, sitka;
    }

    /**
     * Type of Guitar
     */
    enum Type {
        electric, acoustic;
    }

    /**
     * Different manufacturer of guitar
     */
    enum Manufacturer {
        fender, martin, gibson, collings, olson, ryan, prs;
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
     * If value does not match with any of the
     *
     * @param gSpec object of guitar spec class
     */
    public void match(GuitarSpec gSpec) {
        boolean isFound = false;
        this.model = gSpec.model;

        for (BackwoodOrTopwood backwood : BackwoodOrTopwood.values()) {
            if (backwood.name().equals(gSpec.backWood.toLowerCase())) {
                this.backWood = gSpec.backWood;
                isFound = true;
            }
        }
        if (!isFound) {
            this.backWood = "";
        }

        isFound= false;
        for (BackwoodOrTopwood topwood : BackwoodOrTopwood.values()) {
            if (topwood.name().equals(gSpec.topWood.toLowerCase())) {
                this.topWood = gSpec.topWood;
                isFound = true;
            }
        }
        if (!isFound) {
            this.topWood = "";
        }

        isFound= false;
        for (Type type : Type.values()) {
            if (type.name().equals(gSpec.type.toLowerCase())) {
                this.type = gSpec.type;
                isFound = true;
            }
        }
        if (!isFound) {
            this.type = "";
        }


        isFound= false;
        for (Manufacturer manufacturer : Manufacturer.values()) {
            if (manufacturer.name().equals(gSpec.manufacturer.toLowerCase())) {
                this.manufacturer = gSpec.manufacturer;
                isFound = true;
            }
        }
        if (!isFound) {
            this.manufacturer = "";
        }
    }

}

