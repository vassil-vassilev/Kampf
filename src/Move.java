/**
 * Die Klasse Move repraesentiert einen einzelnen Zug.
 *
 * Es gibt zwei Konstruktoren. Einer bekommt
 * Ausgangsfeld und Zielfeld uebergeben, der andere
 * bekommt nur den eingegebenen Zug in der Form
 * <Ausgangsfeld><Zielfeld> als String uebergeben,
 * also z. B. "a7c5" fuer den Zug von "a7" nach "c5".
 */
public class Move {
	
	private static final String[] I = {"1","2","3","4","5","6","7","8"};
    private static final String[] J = {"a","b","c","d","e","f","g","h"};
	
	private String from;
	private String to;

    public Move(String from, String to){
    	this.from = from;
    	this.to = to;
    }

    public Move(String move){
        this.from = "" + move.charAt(0) + move.charAt(1);
        this.to = "" + move.charAt(2) + move.charAt(3);
    }

    @Override
    public String toString(){
        // Rueckgabe exakt in der Form <Ausgangsfeld><Zielfeld> als String,
        // also z. B. "b2b3" fuer den Zug eines Tiers von "b2" nach "b3".
    	return from + to;
    }

    public boolean equals(Object other) {
        return this.toString().equals(other);
    }

}
