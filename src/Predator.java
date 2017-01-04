/**
 * Klasse der Raubtiere.
 */
public class Predator extends Animal {

	public Predator() {
    }

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Predator(boolean female) {
    	super(female);
    }
    
    public Predator(boolean female, String square) {
        super(female, square);
    }
    
    public Predator(boolean female, String square, Position position) {
    	super(female, square, position);
    }

}
