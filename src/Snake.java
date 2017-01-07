public class Snake extends Predator {

	// Eine Schlange kann 9 Tage bzw. Spielrunden ohne Essen auskommen.
	// Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
	// verwendet) werden.
	// private static int withoutFood = 9;

	/**
	 * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
	 *
	 */
	public Snake(boolean female) {
		super(female);
		withoutFood = 9;
		resetLife();
	}

	public Snake(boolean female, String square, Position position) {
		super(female, square, position);
		withoutFood = 9;
		resetLife();
	}

	@Override
	public Move[] possibleMoves() {
		Move[] moves = new Move[100];
		Animal[][] board = this.position.boardRepresentation();
		int m = 0;

		if (getHorPosition() > 0 && getVertPosition() < 7) {
			int next = getHorPosition() - 1;
			for (int j = getVertPosition() + 1; j < 8; j++) {
				if (board[next][j] == null) {
					moves[m] = new Move(this.square, HOR[next] + VERT[j], true);
					m++;
				} else {
					if (canEat(board[next][j])) {
						moves[m] = new Move(this.square, HOR[next] + VERT[j], true);
						m++;
					}
					break;
				}
				if (next != getHorPosition()) {
					next = getHorPosition();
				} else {
					next = getHorPosition() - 1;
				}
			}
		}

		if (getHorPosition() < 7 && getVertPosition() > 0) {
			int next = getHorPosition() + 1;
			for (int j = getVertPosition() - 1; j >= 0; j--) {
				if (board[next][j] == null) {
					moves[m] = new Move(this.square, HOR[next] + VERT[j], true);
					m++;
				} else {
					if (canEat(board[next][j])) {
						moves[m] = new Move(this.square, HOR[next] + VERT[j], true);
						m++;
					}
					break;
				}
				if (next != getHorPosition()) {
					next = getHorPosition();
				} else {
					next = getHorPosition() + 1;
				}
			}
		}

		if (getVertPosition() > 0 && getHorPosition() > 0) {
			int next = getVertPosition() - 1;
			for (int i = getHorPosition() - 1; i >= 0; i--) {
				if (board[i][next] == null) {
					moves[m] = new Move(this.square, HOR[i] + VERT[next], true);
					m++;
				} else {
					if (canEat(board[i][next])) {
						moves[m] = new Move(this.square, HOR[i] + VERT[next], true);
						m++;
					}
					break;
				}
				if (next != getVertPosition()) {
					next = getVertPosition();
				} else {
					next = getVertPosition() - 1;
				}
			}
		}

		if (getVertPosition() < 7 && getHorPosition() < 7) {
			int next = getVertPosition() + 1;
			for (int i = getHorPosition() + 1; i < 8; i++) {
				if (board[i][next] == null) {
					moves[m] = new Move(this.square, HOR[i] + VERT[next], true);
					m++;
				} else {
					if (canEat(board[i][next])) {
						moves[m] = new Move(this.square, HOR[i] + VERT[next], true);
						m++;
					}
					break;
				}
				if (next != getVertPosition()) {
					next = getVertPosition();
				} else {
					next = getVertPosition() + 1;
				}
			}
		}

		if (m > 0) {
			return java.util.Arrays.copyOfRange(moves, 0, m);
		}
		return new Move[0];
	}

	@Override
	public String toString() {
		return this.female
				? (Globals.darkSquare(this.square) ? Globals.ts_female_snake_dark : Globals.ts_female_snake_light)
				: (Globals.darkSquare(this.square) ? Globals.ts_male_snake_dark : Globals.ts_male_snake_light);
	}

}
