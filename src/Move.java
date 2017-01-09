/**
 * Die Klasse Move repraesentiert einen einzelnen Zug.
 *
 * Es gibt zwei Konstruktoren. Einer bekommt Ausgangsfeld und Zielfeld
 * uebergeben, der andere bekommt nur den eingegebenen Zug in der Form
 * <Ausgangsfeld><Zielfeld> als String uebergeben, also z. B. "a7c5" fuer den
 * Zug von "a7" nach "c5".
 */
public class Move {

	private static int vertToIndex(char c) {
		return (c - '1');
	}

	private static int horToIndex(char c) {
		return (c - 'a');
	}

	private String from;
	private String to;
	private boolean isPredator;

	public Move(String from, String to, boolean isPredator) {
		this.from = from;
		this.to = to;
		this.isPredator = isPredator;
	}

	public Move(String move) {
		this.from = "" + move.charAt(0) + move.charAt(1);
		this.to = "" + move.charAt(2) + move.charAt(3);
	}

	@Override
	public String toString() {
		// Rueckgabe exakt in der Form <Ausgangsfeld><Zielfeld> als String,
		// also z. B. "b2b3" fuer den Zug eines Tiers von "b2" nach "b3".
		return from + to;
	}

	public boolean equals(Object other) {
		return this.toString().equals(other);
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public boolean isPredator() {
		return isPredator;
	}
}
