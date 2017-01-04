/**
 * Klasse der Vegetarier.
 */
public class Vegetarian extends Animal {

	public Vegetarian() {
		
	}
    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Vegetarian(boolean female) {
    	super(female);
    }

    public Vegetarian(boolean female, String square, Position position) {
    	super(female, square, position);
    }
}
