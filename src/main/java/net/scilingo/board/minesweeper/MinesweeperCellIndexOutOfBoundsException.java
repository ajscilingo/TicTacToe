package net.scilingo.board.minesweeper;

public class MinesweeperCellIndexOutOfBoundsException extends IndexOutOfBoundsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4007902736941778663L;
	
	MinesweeperCellIndexOutOfBoundsException(){
		super("MinesweeperCell Index is out of bounds");
	}
	
	MinesweeperCellIndexOutOfBoundsException(int index){
		super("MinesweeperCell Index " + index + " is out of bounds");
	}
}
