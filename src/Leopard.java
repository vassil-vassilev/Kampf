public class Leopard extends Predator {

	// Ein Leopard kann nur 5 Tage bzw. Spielrunden ohne Essen auskommen.
	// Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
	// verwendet) werden.
	// private static int withoutFood = 5;

	/**
	 * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
	 *
	 */
	public Leopard(boolean female) {
		super(female);
		withoutFood = 5;
		resetLife();
	}

	public Leopard(boolean female, String square, Position position) {
		super(female, square, position);
		withoutFood = 5;
		resetLife();
	}

	@Override
	public Move[] possibleMoves() {
		Move[] moves = new Move[100];
		Animal[][] board = this.position.boardRepresentation();
		int m = 0;
		for (int i = getVertPosition() + 1; i < 8; i++) {
			if (board[getHorPosition()][i] == null) {
				moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[i], true);
				m++;
			} else {
				if (canEat(board[getHorPosition()][i])) {
					moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[i], true);
					m++;
				}
				break;
			}
		}
		for (int i = getVertPosition() - 1; i >= 0; i--) {
			if (board[getHorPosition()][i] == null) {
				moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[i], true);
				m++;
			} else {
				if (canEat(board[getHorPosition()][i])) {
					moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[i], true);
					m++;
				}
				break;
			}
		}
		for (int i = getHorPosition() + 1; i < 8; i++) {
			if (board[i][getVertPosition()] == null) {
				moves[m] = new Move(this.square, HOR[i] + VERT[getVertPosition()], true);
				m++;
			} else {
				if (canEat(board[i][getVertPosition()])) {
					moves[m] = new Move(this.square, HOR[i] + VERT[getVertPosition()], true);
					m++;
				}
				break;
			}
		}
		for (int i = getHorPosition() - 1; i >= 0; i--) {
			if (board[i][getVertPosition()] == null) {
				moves[m] = new Move(this.square, HOR[i] + VERT[getVertPosition()], true);
				m++;
			} else {
				if (canEat(board[i][getVertPosition()])) {
					moves[m] = new Move(this.square, HOR[i] + VERT[getVertPosition()], true);
					m++;
				}
				break;
			}
		}

		// Diagonal
		int j = getVertPosition() + 1;
		for (int i = getHorPosition() + 1; i < 8; i++) {
			if (j < 8 && board[i][j] == null) {
				moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
				m++;
				j++;
			} else {
				if (j < 8 && canEat(board[i][j])) {
					moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
					m++;
				}
				break;
			}
		}
		j = getVertPosition() - 1;
		for (int i = getHorPosition() + 1; i < 8; i++) {
			if (j >= 0 && board[i][j] == null) {
				moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
				m++;
				j--;
			} else {
				if (j >= 0 && canEat(board[i][j])) {
					moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
					m++;
				}
				break;
			}
		}
		j = getVertPosition() + 1;
		for (int i = getHorPosition() - 1; i >= 0; i--) {
			if (j < 8 && board[i][j] == null) {
				moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
				m++;
				j++;
			} else {
				if (j < 8 && canEat(board[i][j])) {
					moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
					m++;
				}
				break;
			}
		}
		j = getVertPosition() - 1;
		for (int i = getHorPosition() - 1; i >= 0; i--) {
			if (j >= 0 && board[i][j] == null) {
				moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
				m++;
				j--;
			} else {
				if (j >= 0 && canEat(board[i][j])) {
					moves[m] = new Move(this.square, HOR[i] + VERT[j], true);
					m++;
				}
				break;
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
				? (Globals.darkSquare(this.square) ? Globals.ts_female_leopard_dark : Globals.ts_female_leopard_light)
				: (Globals.darkSquare(this.square) ? Globals.ts_male_leopard_dark : Globals.ts_male_leopard_light);
	}

}
