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

	public boolean canEat(Animal target) {
		// Check if vegetarian and the opposite player
		return withoutFood == -100 && (target.female != female);
	}

	@Override
	public void resetLife() {
		daysToLive = withoutFood;
	}

	@Override
	public void sunset() {
		daysToLive--;
		if (daysToLive == -1) {
			alive = false;
		}
	}
}
