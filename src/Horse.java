public class Horse extends Vegetarian {

	/**
	 * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
	 *
	 */
	public Horse(boolean female) {
		super(female);
	}

	public Horse(boolean female, String square, Position position) {
		super(female, square, position);
	}

	@Override
	public Move[] possibleMoves() {
		Move[] moves = new Move[100];
		Animal[][] board = this.position.boardRepresentation();
		int m = 0;

		if (getVertPosition() < 7 && board[getHorPosition()][getVertPosition() + 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[getVertPosition() + 1]);
			m++;
		}
		if (getVertPosition() > 0 && board[getHorPosition()][getVertPosition() - 1] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[getVertPosition() - 1]);
			m++;
		}
		if (getHorPosition() < 7 && board[getHorPosition() + 1][getVertPosition()] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 1] + VERT[getVertPosition()]);
			m++;
		}
		if (getHorPosition() > 0 && board[getHorPosition() - 1][getVertPosition()] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 1] + VERT[getVertPosition()]);
			m++;
		}

		// 2 Felder
		if (getVertPosition() < 6 && getHorPosition() < 6
				&& board[getHorPosition() + 2][getVertPosition() + 2] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 2] + VERT[getVertPosition() + 2]);
			m++;
		}
		if (getVertPosition() < 6 && getHorPosition() > 1
				&& board[getHorPosition() - 2][getVertPosition() + 2] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 2] + VERT[getVertPosition() + 2]);
			m++;
		}
		if (getVertPosition() > 1 && getHorPosition() > 1
				&& board[getHorPosition() - 2][getVertPosition() - 2] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 2] + VERT[getVertPosition() - 2]);
			m++;
		}
		if (getVertPosition() > 1 && getHorPosition() < 6
				&& board[getHorPosition() + 2][getVertPosition() - 2] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 2] + VERT[getVertPosition() - 2]);
			m++;
		}

		// 3 Felder
		if (getVertPosition() < 5 && getHorPosition() < 5
				&& board[getHorPosition() + 3][getVertPosition() + 3] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 3] + VERT[getVertPosition() + 3]);
			m++;
		}
		if (getVertPosition() < 5 && getHorPosition() > 2
				&& board[getHorPosition() - 3][getVertPosition() + 3] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 3] + VERT[getVertPosition() + 3]);
			m++;
		}
		if (getVertPosition() > 2 && getHorPosition() > 2
				&& board[getHorPosition() - 3][getVertPosition() - 3] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() - 3] + VERT[getVertPosition() - 3]);
			m++;
		}
		if (getVertPosition() > 2 && getHorPosition() < 5
				&& board[getHorPosition() + 3][getVertPosition() - 3] == null) {
			moves[m] = new Move(this.square, HOR[getHorPosition() + 3] + VERT[getVertPosition() - 3]);
			m++;
		}
		
		if(m > 0) {
    		return java.util.Arrays.copyOfRange(moves, 0, m);
    	}
    	return new Move[0];
	}

	@Override
	public String toString() {
		return this.female
				? (Globals.darkSquare(this.square) ? Globals.ts_female_horse_dark : Globals.ts_female_horse_light)
				: (Globals.darkSquare(this.square) ? Globals.ts_male_horse_dark : Globals.ts_male_horse_light);
	}

}
