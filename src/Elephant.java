public class Elephant extends Vegetarian {

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Elephant(boolean female) {
    	super(female);
    }
    
    public Elephant(boolean female, String square, Position position) {
    	super(female, square, position);
    }
    
    @Override
    public Move[] possibleMoves() {
    	Move[] moves = new Move[100];
    	Animal[][] board = this.position.boardRepresentation();
    	int m = 0;
    	for(int i = getVertPosition() + 1; i < 8; i++) {
    		if(board[getHorPosition()][i] == null) {
    			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[i]);
    			m++;
    		} else {
    			break;
    		}
    	}
    	for(int i = getVertPosition() - 1; i >= 0; i--) {
    		if(board[getHorPosition()][i] == null) {
    			moves[m] = new Move(this.square, HOR[getHorPosition()] + VERT[i]);
    			m++;
    		} else {
    			break;
    		}
    	}
    	for(int i = getHorPosition() + 1; i < 8; i++) {
    		if(board[i][getVertPosition()] == null) {
    			moves[m] = new Move(this.square, HOR[i] + VERT[getVertPosition()]);
    			m++;
    		} else {
    			break;
    		}
    	}
    	for(int i = getHorPosition() - 1; i >= 0; i--) {
    		if(board[i][getVertPosition()] == null) {
    			moves[m] = new Move(this.square, HOR[i] + VERT[getVertPosition()]);
    			m++;
    		} else {
    			break;
    		}
    	}
    	
    	if(m > 0) {
    		return java.util.Arrays.copyOfRange(moves, 0, m);
    	}
    	return new Move[0];
    }

	@Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_elephant_dark : Globals.ts_female_elephant_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_elephant_dark : Globals.ts_male_elephant_light);
    }

}
