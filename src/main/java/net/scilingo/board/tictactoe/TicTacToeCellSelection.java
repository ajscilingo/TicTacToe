package net.scilingo.board.tictactoe;

import net.scilingo.board.CellSelection;

public enum TicTacToeCellSelection implements CellSelection{
	UPPER_LEFT {
		@Override
		public TicTacToeCellSelection[] getAdjacentCells(){
			return new TicTacToeCellSelection[]{UPPER_MIDDLE, MIDDLE_LEFT, MIDDLE_MIDDLE};
		}
	},
	UPPER_MIDDLE {
		@Override
		public TicTacToeCellSelection[] getAdjacentCells(){
			return new TicTacToeCellSelection[]{UPPER_LEFT, UPPER_RIGHT, MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT};
		}
	},
	UPPER_RIGHT {
		@Override
		public TicTacToeCellSelection[] getAdjacentCells() {
			return new TicTacToeCellSelection[] {UPPER_MIDDLE, MIDDLE_MIDDLE, MIDDLE_RIGHT};
		}
	},
	MIDDLE_LEFT{
		@Override
		public TicTacToeCellSelection[] getAdjacentCells() {
			return new TicTacToeCellSelection[] {UPPER_LEFT, UPPER_MIDDLE, MIDDLE_MIDDLE, LOWER_LEFT, LOWER_MIDDLE};
		}
	},
	MIDDLE_MIDDLE{
		@Override
		public TicTacToeCellSelection[] getAdjacentCells() {
			return new TicTacToeCellSelection[] {UPPER_RIGHT, UPPER_MIDDLE, UPPER_LEFT, MIDDLE_RIGHT, MIDDLE_LEFT, LOWER_RIGHT, LOWER_MIDDLE, LOWER_LEFT};
		}
	},
	MIDDLE_RIGHT{
		@Override
		public TicTacToeCellSelection[] getAdjacentCells() {
			return new TicTacToeCellSelection[]{UPPER_RIGHT, UPPER_MIDDLE, MIDDLE_MIDDLE, LOWER_RIGHT, LOWER_MIDDLE};
		}
	},
	LOWER_LEFT{
		@Override
		public TicTacToeCellSelection[] getAdjacentCells() {
			return new TicTacToeCellSelection[]{MIDDLE_LEFT, MIDDLE_MIDDLE, LOWER_MIDDLE};
		}
	},
	LOWER_MIDDLE{
		@Override
		public TicTacToeCellSelection[] getAdjacentCells() {
			return new TicTacToeCellSelection[]{MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT, LOWER_LEFT, LOWER_RIGHT};
		}
	},
	LOWER_RIGHT{
		@Override
		public TicTacToeCellSelection[] getAdjacentCells() {
			return new TicTacToeCellSelection[]{MIDDLE_MIDDLE, MIDDLE_RIGHT, LOWER_MIDDLE};
		}
	};

	public abstract TicTacToeCellSelection[] getAdjacentCells();

}
