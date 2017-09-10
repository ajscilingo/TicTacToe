package net.scilingo.board.minesweeper;

public class MinesweeperCellSetMaxRowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9019655816876775215L;

	public MinesweeperCellSetMaxRowException() {
		super("Max row Dimension must be size 4 or greater");
	}
	
	public MinesweeperCellSetMaxRowException(int maxRow) {
		super("Max row Dimension must be size 4 or greater: size is " + maxRow);
	}
}
