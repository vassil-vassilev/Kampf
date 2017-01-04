/**
 * Oberklasse fuer Tiere.
 */
public class Animal {
	
	protected static final String[] VERT = {"1","2","3","4","5","6","7","8"};
	protected static final String[] HOR = {"a","b","c","d","e","f","g","h"};
    private static int charToIndex(char c){return (c-'1');}
    private static int stringToIndex(String s){return (s.charAt(0)-'a');}

    // Attribute fuer den allen Tieren gemeinen Teil des Tierzustands
    public boolean female; // Weibchen?
    public boolean alive;  // Lebendig?
    public String square;  // Auf welchem Feld? (genau zwei Zeichen, z. B. "e4")
    public Position position; // Auf welchem Spielbrett?

    public Animal() {
    }

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Animal(boolean female) {
        this.female = female;
    }
    
    public Animal(boolean female, String square) {
        this.female = female;
        this.square = square;
    }
    
    public Animal(boolean female, String square, Position position) {
        this.female = female;
        this.square = square;
        this.position = position;
    }
    
    public int getVertPosition() {
    	return charToIndex(square.charAt(1));
    }
    
    public int getHorPosition() {
    	return  stringToIndex("" + square.charAt(0));
    }

    /**
     * Ermittelt die moeglichen Zuege gemaess den Spielregeln,
     * die das Tier von seinem Feld aus in der aktuellen Position
     * ausfuehren kann.
     *
     * Muss von jeder einzelnen Tierklasse ueberschrieben werden.
     */
    public Move[] possibleMoves(){
        return new Move[0];
    }


    /**
     * Wird aufgerufen nach jeder Spielrunde
     * (quasi am Ende vom Tag - jede Spielrunde zaehlt als ein Tag).
     *
     *  Muss in jeder einzelnen Tierklasse ueberschrieben sein!
     */
    public void sunset(){
        // Methode (und Klasse Animal) sollten eigentlich als abstract deklariert sein.
        // Kommt spaeter in der Vorlesung noch dran...
        // Zum Verstaendnis reicht es, dass diese Methode ueberschrieben werden muss.
        // (Die folgende Zeile wird dann auch nie ausgefuehrt.)
        throw new RuntimeException("Method sunset should have been overridden");
    }

}
