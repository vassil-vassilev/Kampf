/**
 * Die Klasse Game fuehrt die Benutzerinteraktion durch.
 *
 */

public class Game {

	private Position pos;

	/**
	 * Startet ein neues Spiel. Der Benutzer wird ueber das Spielgeschehen
	 * informiert.
	 *
	 * Dazu gehoert auch die Information, wie lange die einzelnen Raubtiere noch
	 * ohne Essen auskommen koennen. Diese Information soll auf Anfrage oder
	 * immer angezeigt werden.
	 *
	 * Es soll ausserdem eine Moeglichkeit geben, sich alle Zuege anzeigen zu
	 * lassen, die in der Spielsituation moeglich sind.
	 *
	 * Bei fehlerhaften Eingaben wird die Eingabe natuerlich wiederholt.
	 *
	 * Der Parameter spezifiziert, wer das Spiel beginnen darf.
	 */
	public void startGame(boolean ladiesFirst) {
		pos = new Position();
		pos.reset(ladiesFirst ? 'W' : 'M');

		while (pos.theWinner() == 'X') {
			System.out.print(pos.toString());

			Move[] validMoves = pos.possibleMoves();
			Move[] movesTaken = new Move[4];
			int nrMoves = 0;
			boolean valid = false;

			while (!valid) {
				String action = IO.readString(
						"Choose an action:\nP - for pass, M - for possible moves, L - for the life of the predators or enter a valid move\n");
				if (action.equals("P") || action.equals("M") || action.equals("L")) {
					if (action.equals("P")) {
						valid = true;
					} else if (action.equals("M")) {
						for (Move m : validMoves) {
							if (m == null)
								break;
							System.out.println(m.toString());
						}
					} else {
						pos.predatorsLifes();
					}

				} else {
					for (Move m : validMoves) {
						// Valid move
						if (m != null && m.toString().equals(action)) {
							movesTaken[nrMoves] = m;
							nrMoves++;
							// 4 moves taken so no more input is required
							if (nrMoves == 4) {
								valid = true;
							}
							break;
						}
					}
				}
			}

			// Moves entered - apply them
			pos.applyMoves(movesTaken);
		}

		System.out.println("Winner: " + pos.theWinner());
	}
}
