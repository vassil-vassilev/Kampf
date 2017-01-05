public class Penguin extends Predator {

	// Ein Pinguin kann 12 Tage bzw. Spielrunden ohne Essen auskommen.
	// Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
	// verwendet) werden.
	private static int withoutFood = 12;

	/**
	 * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
	 *
	 */
	public Penguin(boolean female) {
		super(female);
	}

	public Penguin(boolean female, String square, Position position) {
		super(female, square, position);
	}

	@Override
	public Move[] possibleMoves() {
		Move[] moves = new Move[100];
		Animal[][] board = this.position.boardRepresentation();
		int m = 0;

		if (getVertPosition() < 7 && (board[getHorPosition()][getVertPosition() + 1] == null
				|| canEat(board[getHorPosition()][getVertPosition() + 1]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[getVertPosition() + 1]);
			m++;
		}
		if (getVertPosition() > 0 && (board[getHorPosition()][getVertPosition() - 1] == null
				|| canEat(board[getHorPosition()][getVertPosition() - 1]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[getVertPosition() - 1]);
			m++;
		}
		if (getHorPosition() < 7 && (board[getHorPosition() + 1][getVertPosition()] == null
				|| canEat(board[getHorPosition() + 1][getVertPosition()]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 1] + VERT[getVertPosition()]);
			m++;
		}
		if (getHorPosition() > 0 && (board[getHorPosition() - 1][getVertPosition()] == null
				|| canEat(board[getHorPosition() - 1][getVertPosition()]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 1] + VERT[getVertPosition()]);
			m++;
		}

		if (getVertPosition() < 7 && getHorPosition() < 7 && (board[getHorPosition() + 1][getVertPosition() + 1] == null
				|| canEat(board[getHorPosition() + 1][getVertPosition() + 1]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 1] + VERT[getVertPosition() + 1]);
			m++;
		}
		if (getVertPosition() < 7 && getHorPosition() > 0 && (board[getHorPosition() - 1][getVertPosition() + 1] == null
				|| canEat(board[getHorPosition() - 1][getVertPosition() + 1]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 1] + VERT[getVertPosition() + 1]);
			m++;
		}
		if (getVertPosition() > 0 && getHorPosition() > 0 && (board[getHorPosition() - 1][getVertPosition() - 1] == null
				|| canEat(board[getHorPosition() - 1][getVertPosition() - 1]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 1] + VERT[getVertPosition() - 1]);
			m++;
		}
		if (getVertPosition() > 0 && getHorPosition() < 7 && (board[getHorPosition() + 1][getVertPosition() - 1] == null
				|| canEat(board[getHorPosition() + 1][getVertPosition() - 1]))) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 1] + VERT[getVertPosition() - 1]);
			m++;
		}

		if (m > 0) {
			return java.util.Arrays.copyOfRange(moves, 0, m);
		}
		return new Move[0];
	}

	@Override
	public String toString() {
		return this.female
				? (Globals.darkSquare(this.square) ? Globals.ts_female_penguin_dark : Globals.ts_female_penguin_light)
				: (Globals.darkSquare(this.square) ? Globals.ts_male_penguin_dark : Globals.ts_male_penguin_light);
	}

}
