import java.util.Arrays;

/**
 * Die Klasse Position repraesentiert eine Spielsituation.
 *
 */
public class Position {

	/**
	 * Die Tiere werden intern in einem Array gespeichert. nrAnimals gibt an,
	 * wie viele Tiere auf dem Brett sind. Diese sind in myAnimals an den
	 * Positionen 0 bis nrAnimals-1 enthalten.
	 *
	 * Es ist empfohlen, aber nicht vorgeschrieben, diese Attribute zu
	 * verwenden.
	 *
	 * Falls die beiden Attribute NICHT verwendet werden, muss die Ausgabe der
	 * Spielposition unten entsprechend auf die verwendete Datenstruktur
	 * angepasst werden. Die toString-Methode darf dabei nicht veraendert
	 * werden, muss jedoch die selbe Rueckgabe liefern. D.h. es ist dann
	 * notwendig, die Hilfsmethode boardRepresentation auf die verwendete
	 * Datenstruktur anzupassen.
	 */
	private Animal[] myAnimals;
	private int nrAnimals;

	/**
	 * Spieler, der als naechstes ziehen darf ('M' oder 'W'). Wird jedes Mal
	 * aktualisiert, wenn eine Seite ihre Zuege ausfuehrt.
	 */
	private char next = 'W';

	private char firstPlayer;

	/**
	 * Stellt die Anfangsposition des Spiels her. Der Parameter gibt an, welche
	 * Seite beginnt ('M' oder 'W').
	 */
	public void reset(char movesNext) {
		firstPlayer = movesNext;
		next = movesNext;
		myAnimals = new Animal[32];
		nrAnimals = 32;

		myAnimals[0] = new Snake(true, "a1", this);
		myAnimals[1] = new Elephant(true, "b1", this);
		myAnimals[2] = new Horse(true, "c1", this);
		myAnimals[3] = new Leopard(true, "d1", this);
		myAnimals[4] = new Leopard(true, "e1", this);
		myAnimals[5] = new Horse(true, "f1", this);
		myAnimals[6] = new Elephant(true, "g1", this);
		myAnimals[7] = new Snake(true, "h1", this);
		myAnimals[8] = new Penguin(true, "a2", this);
		myAnimals[9] = new Rabbit(true, "b2", this);
		myAnimals[10] = new Rabbit(true, "c2", this);
		myAnimals[11] = new Rabbit(true, "d2", this);
		myAnimals[12] = new Rabbit(true, "e2", this);
		myAnimals[13] = new Rabbit(true, "f2", this);
		myAnimals[14] = new Rabbit(true, "g2", this);
		myAnimals[15] = new Penguin(true, "h2", this);

		myAnimals[16] = new Snake(false, "a8", this);
		myAnimals[17] = new Elephant(false, "b8", this);
		myAnimals[18] = new Horse(false, "c8", this);
		myAnimals[19] = new Leopard(false, "d8", this);
		myAnimals[20] = new Leopard(false, "e8", this);
		myAnimals[21] = new Horse(false, "f8", this);
		myAnimals[22] = new Elephant(false, "g8", this);
		myAnimals[23] = new Snake(false, "h8", this);
		myAnimals[24] = new Penguin(false, "a7", this);
		myAnimals[25] = new Rabbit(false, "b7", this);
		myAnimals[26] = new Rabbit(false, "c7", this);
		myAnimals[27] = new Rabbit(false, "d7", this);
		myAnimals[28] = new Rabbit(false, "e7", this);
		myAnimals[29] = new Rabbit(false, "f7", this);
		myAnimals[30] = new Rabbit(false, "g7", this);
		myAnimals[31] = new Penguin(false, "h7", this);
	}

	/**
	 * Fuehrt die uebergebenen Zuege fuer einen der Spieler aus. Die Reihenfolge
	 * soll keinen Unterschied machen. Diese Methode geht davon aus, dass dies
	 * bereits ueberprueft wurde.
	 *
	 * Der Zustand des Spiels wird entsprechend angepasst, d. h. ein Spiel kann
	 * von der Anfangsposition aus allein mittels Aufrufen dieser Methode
	 * gespielt werden. Insbesondere wechselt durch den Aufruf das Zugrecht, da
	 * M und W abwechselnd ziehen.
	 *
	 * @param move
	 *            Array mit den Zuegen, die ausgefuehrt werden sollen.
	 *
	 */
	public void applyMoves(Move[] move) {
		for (int i = 0; i < move.length; i++) {
			if (move[i] != null) {
				int animalIndexToMove = findAnimalIndexBySquare(move[i].getFrom());
				int animalIndexToRemove = findAnimalIndexBySquare(move[i].getTo());

				myAnimals[animalIndexToMove].square = move[i].getTo();

				if (animalIndexToRemove > -1) {
					myAnimals[animalIndexToRemove] = null;
					// Eat
					myAnimals[animalIndexToMove].resetLife();
				}
			}
		}

		removeDeadAnimals();

		if (next == 'W')
			next = 'M';
		else
			next = 'W';

		checkEndOfTurn();
	}

	private int findAnimalIndexBySquare(String square) {

		for (int j = 0; j < myAnimals.length; j++) {
			if (myAnimals[j] != null && myAnimals[j].square.equals(square)) {
				return j;
			}
		}

		return -1;
	}

	public Move[] possibleMoves() {
		Move[] possibleMoves = new Move[100];
		int nrMoves = 0;

		for (int i = 0; i < myAnimals.length; i++) {
			if ((next == 'W' && myAnimals[i].female) || (next == 'M' && !myAnimals[i].female)) {
				Move[] moves = myAnimals[i].possibleMoves();
				for (int j = 0; j < moves.length; j++) {
					possibleMoves[nrMoves] = moves[j];
					nrMoves++;
				}
			}
		}

		return possibleMoves;
	}

	public void checkEndOfTurn() {
		// End of turn
		if (next == firstPlayer) {
			for (int i = 0; i < myAnimals.length; i++) {
				myAnimals[i].sunset();
				if (!myAnimals[i].alive) {
					myAnimals[i] = null;
				}
			}

			removeDeadAnimals();
		}
	}

	public void removeDeadAnimals() {
		// Remove empty
		Animal[] newArray = new Animal[32];
		nrAnimals = 0;
		for (int i = 0; i < myAnimals.length; i++) {
			if (myAnimals[i] != null) {
				newArray[nrAnimals] = myAnimals[i];
				nrAnimals++;
			}
		}
		myAnimals = Arrays.copyOfRange(newArray, 0, nrAnimals);
	}

	public void predatorsLifes() {
		for (int i = 0; i < myAnimals.length; i++) {
			// Traverse my predators
			if (myAnimals[i].withoutFood > 0
					&& ((next == 'W' && myAnimals[i].female) || (next == 'M' && !myAnimals[i].female))) {
				System.out.println(myAnimals[i].square + " - " + myAnimals[i].daysToLive);
			}
		}
	}

	/**
	 * Ermittelt, ob/wer gewonnen hat.
	 *
	 * @return 'W' falls W gewonnen hat, 'M' falls M gewonnen hat, 'N' falls das
	 *         Spiel unentschieden zu Ende ist, 'X' falls das Spiel noch nicht
	 *         zu Ende ist.
	 *
	 */
	public char theWinner() {
		int mPredators = 0;
		int mVegetarian = 0;
		int wPredators = 0;
		int wVegetarian = 0;

		if (nrAnimals == 0)
			return 'N';

		for (int i = 0; i < myAnimals.length; i++) {
			// Vegetarian
			if (myAnimals[i].withoutFood == -100) {
				if (myAnimals[i].female)
					wVegetarian++;
				else
					mVegetarian++;
			} else {
				if (myAnimals[i].female)
					wPredators++;
				else
					mPredators++;
			}
		}

		if (mPredators == 0 && wPredators == 0) {
			if (mVegetarian > wVegetarian)
				return 'M';
			else
				return 'W';
		}

		return 'X';
	}

	// Ausgabe der Spielposition

	private static final int[] I = { 8, 7, 6, 5, 4, 3, 2, 1 };
	private static final String[] J = { "a", "b", "c", "d", "e", "f", "g", "h" };

	private static int toIndex(String s) {
		return (s.charAt(0) - 'a');
	}

	// Erzeugt eine 2D-Repraesentation der Spielposition.
	// Darf ggf. auf neue Datenstruktur angepasst werden (s.o.)
	// Die Rueckgabe ist ein zweidimensionales Array, welches
	// jedem Feld das darauf befindliche Tier (oder null) zuordnet.
	// Dabei laeuft der erste Index von der 'a'-Linie zur 'h'-Linie,
	// der zweite von der 1. zur 8. Reihe. D.h. wenn z.B. bei a[3][7]
	// ein Tier ist, ist das zugehörige Feld "d8" (vierter Buchstabe,
	// achte Zahl).
	public Animal[][] boardRepresentation() {
		Animal[][] a = new Animal[8][8];
		for (int i : I) {
			for (String j : J) {
				for (int k = 0; k < myAnimals.length; k++) {
					if (null == myAnimals[k]) {
						break;
					}
					if (myAnimals[k].square.equals(j + i)) {
						a[toIndex(j)][i - 1] = myAnimals[k];
					}
				}
			}
		}
		return a;
	}

	@Override
	public String toString() {
		String str = "   a  b  c  d  e  f  g  h\n";
		Animal[][] ani = boardRepresentation();
		for (int i : I) {
			str += (i + " ");
			for (String j : J) {
				if (null == ani[toIndex(j)][i - 1]) {
					str += (i + toIndex(j)) % 2 == 1 ? Globals.ts_empty_square_dark : Globals.ts_empty_square_light;
				} else {
					str += ani[toIndex(j)][i - 1].toString();
				}
			}
			str += " " + i + "\n";
		}
		str += "   a  b  c  d  e  f  g  h\nIt is " + next + "'s turn.\n";
		return str;
	}

}
