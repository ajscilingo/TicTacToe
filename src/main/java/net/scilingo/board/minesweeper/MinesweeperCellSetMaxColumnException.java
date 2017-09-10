package net.scilingo.board.minesweeper;

public class MinesweeperCellSetMaxColumnException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1109801749038934281L;

	public MinesweeperCellSetMaxColumnException() {
		super("Max Column Dimension must be size 4 or greater");
	}
	
	public MinesweeperCellSetMaxColumnException(int maxColumn) {
		super("Max Column Dimension must be size 4 or greater: size is " + maxColumn);
	}
}
