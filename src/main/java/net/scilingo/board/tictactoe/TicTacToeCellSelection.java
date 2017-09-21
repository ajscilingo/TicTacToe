package net.scilingo.board.tictactoe;

import net.scilingo.board.CellSelection;

public enum TicTacToeCellSelection implements CellSelection {
	UPPER_LEFT,
	UPPER_MIDDLE,
	UPPER_RIGHT,
	MIDDLE_LEFT,
	MIDDLE_MIDDLE,
	MIDDLE_RIGHT,
	LOWER_LEFT,
	LOWER_MIDDLE,
	LOWER_RIGHT;
	
	public static TicTacToeCellSelection[] getAdjacentCells(TicTacToeCellSelection cell) {
		
		switch(cell) {
			case	 UPPER_LEFT:
				return new TicTacToeCellSelection[]{UPPER_MIDDLE, MIDDLE_LEFT, MIDDLE_MIDDLE};
			case UPPER_MIDDLE:
				return new TicTacToeCellSelection[]{UPPER_LEFT, UPPER_RIGHT, MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT};
			case UPPER_RIGHT:
				return new TicTacToeCellSelection[] {UPPER_MIDDLE, MIDDLE_MIDDLE, MIDDLE_RIGHT};
			case MIDDLE_LEFT:
				return new TicTacToeCellSelection[] {UPPER_RIGHT, UPPER_MIDDLE, MIDDLE_MIDDLE, LOWER_LEFT, LOWER_MIDDLE};
			case MIDDLE_MIDDLE:
				return new TicTacToeCellSelection[] {UPPER_RIGHT, UPPER_MIDDLE, UPPER_LEFT, MIDDLE_RIGHT, MIDDLE_LEFT, LOWER_RIGHT, LOWER_MIDDLE, LOWER_LEFT};
			case MIDDLE_RIGHT:
				return new TicTacToeCellSelection[]{UPPER_RIGHT, UPPER_MIDDLE, MIDDLE_MIDDLE, LOWER_RIGHT, LOWER_MIDDLE};
			case LOWER_LEFT:
				return new TicTacToeCellSelection[]{MIDDLE_RIGHT, MIDDLE_MIDDLE, LOWER_MIDDLE};
			case LOWER_MIDDLE:
				return new TicTacToeCellSelection[]{MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT, LOWER_LEFT, LOWER_RIGHT};
			case LOWER_RIGHT:
				return new TicTacToeCellSelection[]{MIDDLE_MIDDLE, MIDDLE_RIGHT, LOWER_MIDDLE};
			default:
				return null;
		}
	}
}
