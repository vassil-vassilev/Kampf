public class Rabbit extends Vegetarian {

	/**
	 * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
	 *
	 */
	public Rabbit(boolean female) {
		super(female);
	}

	public Rabbit(boolean female, String square, Position position) {
		super(female, square, position);
	}

	@Override
	public Move[] possibleMoves() {
		Move[] moves = new Move[100];
		Animal[][] board = this.position.boardRepresentation();
		int m = 0;

		if (getVertPosition() < 7 && board[getHorPosition()][getVertPosition() + 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[getVertPosition() + 1], false);
			m++;
		}
		if (getVertPosition() > 0 && board[getHorPosition()][getVertPosition() - 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[getVertPosition() - 1], false);
			m++;
		}
		if (getHorPosition() < 7 && board[getHorPosition() + 1][getVertPosition()] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 1] + VERT[getVertPosition()], false);
			m++;
		}
		if (getHorPosition() > 0 && board[getHorPosition() - 1][getVertPosition()] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 1] + VERT[getVertPosition()], false);
			m++;
		}

		if (getVertPosition() < 7 && getHorPosition() < 7
				&& board[getHorPosition() + 1][getVertPosition() + 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 1] + VERT[getVertPosition() + 1], false);
			m++;
		}
		if (getVertPosition() < 7 && getHorPosition() > 0
				&& board[getHorPosition() - 1][getVertPosition() + 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 1] + VERT[getVertPosition() + 1], false);
			m++;
		}
		if (getVertPosition() > 0 && getHorPosition() > 0
				&& board[getHorPosition() - 1][getVertPosition() - 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 1] + VERT[getVertPosition() - 1], false);
			m++;
		}
		if (getVertPosition() > 0 && getHorPosition() < 7
				&& board[getHorPosition() + 1][getVertPosition() - 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 1] + VERT[getVertPosition() - 1], false);
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
				? (Globals.darkSquare(this.square) ? Globals.ts_female_rabbit_dark : Globals.ts_female_rabbit_light)
				: (Globals.darkSquare(this.square) ? Globals.ts_male_rabbit_dark : Globals.ts_male_rabbit_light);
	}

}
