/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 1
 * Date: 2018-09-14
 * Students:  Tejal Shroff (@01387716)
 */
package HW2.edu.fitchburgstate.csc7400;

/**
 * Contains attributes of Guitar (enum)
 * Match method matches the enum value and the user value.
 *
 * @author Tejal Shroff
 */
public class GuitarSpec {
    /**
     * Default constructor
     */
    public GuitarSpec() {
    }

    /**
     * Full Constructor
     * @param manufacturer the guitar's manufacturer enum
     * @param model  the manufacturers model
     * @param type guitar type (electric/accoustic) enum
     * @param backWood the wood used for the guitar body enum
     * @param topWood  the wood used for the guitar's face enum
     */
    public GuitarSpec(Manufacturer manufacturer, String model,
                      Type type, BackwoodOrTopwood backWood,
                      BackwoodOrTopwood topWood) {

        this.model = model.toLowerCase();
        this.manufacturer = manufacturer;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    /**
     * Type of back wood and face/top wood for guitar
     */
    public enum BackwoodOrTopwood {
        indianrosewood, brazilianrosewood, mahogany, maple, cocobolo, cedar, adirondack, alder, sitka;
    }

    /**
     * Type of Guitar
     */
    public enum Type {
        electric, acoustic;
    }

    /**
     * Different manufacturer of guitar
     */
    public enum Manufacturer {
        fender, martin, gibson, collings, olson, ryan, prs;
    }


    /**
     * The guitar type (electric/acoustic)
     */
    private Type type;

    /**
     * The wood used for the back of the guitar
     */
    private BackwoodOrTopwood backWood;

    /**
     * The wood used for the face of the guitar
     */
    private BackwoodOrTopwood topWood;

    /**
     * The name of the manufacturer
     */
    private Manufacturer manufacturer;

    /**
     * The manufacturer model number
     */
    private String model;

    /**
     * Returns the name of the manufacturer
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
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
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the type of wood used in the body
     */
    public BackwoodOrTopwood getBackWood() {
        return backWood;
    }

    /**
     * Returns the type of wood used in the face
     */
    public BackwoodOrTopwood getTopWood() {
        return topWood;
    }


    /**
     * Matches the current guitar spec specified by user to the guitar spec available in the enum
     * Every attribute that user has specified will be checked in enum
     * (enum has all the constant values for the guitar categories)
     * If value does not match with any of the
     * If guitar spec values of guitar list is null return false (no match found)
     * @param gSpec object of guitar spec class
     * @param guitar object of guitar class
     */
    public boolean match(GuitarSpec gSpec, Guitar guitar) {

        if(gSpec == null || guitar== null)
        {
            return false;
        }
        Manufacturer builder = gSpec.getManufacturer();
        if ((builder != null) &&
                (!builder.equals(guitar.gSpec.getManufacturer())))
            return false;
        String model = gSpec.getModel();
        if ((model != null) && (!model.equals("")) &&
                (!model.equals(guitar.gSpec.getModel())))
            return false;
        Type type = gSpec.getType();
        if ((type != null) &&
                (!type.equals(guitar.gSpec.getType())))
            return false;
        BackwoodOrTopwood backWood = gSpec.getBackWood();
        if ((backWood != null) &&
                (!backWood.equals(guitar.gSpec.getBackWood())))
            return false;
        BackwoodOrTopwood topWood = gSpec.getTopWood();
        if ((topWood != null) &&
                (!topWood.equals(guitar.gSpec.getTopWood())))
            return false;

        return true;
    }
}