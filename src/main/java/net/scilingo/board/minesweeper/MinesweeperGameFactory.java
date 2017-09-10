package net.scilingo.board.minesweeper;

public class MinesweeperGameFactory {

	private static MinesweeperGameBoard _minesweeperGameBoard;
	
	public static MinesweeperGameBoard generateGameBoard() {
		_minesweeperGameBoard = generateGameBoard(MinesweeperCellProperties.getMaxRow(), MinesweeperCellProperties.getMaxColumn());
		return _minesweeperGameBoard;
	}
	
	public static MinesweeperGameBoard  generateGameBoard(int rows, int columns) {
		if(_minesweeperGameBoard == null) {
			try {
			
				_minesweeperGameBoard = new MinesweeperGameBoard(rows, columns);
			
			}
			catch(MinesweeperCellSetMaxRowException | MinesweeperCellSetMaxColumnException outterException) {
				
				outterException.printStackTrace();
				System.err.println("\tSetting board to default dimensions: 4x4");
				
				try {
					_minesweeperGameBoard = new MinesweeperGameBoard();
				}
				catch(MinesweeperCellSetMaxRowException | MinesweeperCellSetMaxColumnException innerException) {
					innerException.printStackTrace();
					System.err.println("\tboard creation failed");
				}
			}
			
		}
		
		return _minesweeperGameBoard;
	}
	
}
