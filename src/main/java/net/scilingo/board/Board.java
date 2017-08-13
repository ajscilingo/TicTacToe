package net.scilingo.board;

public class Board {

	protected char [][] _gameBoard;
	private static int rows = 3;
	private static int cols = 3;
	
	public Board(){
		_gameBoard = new char[rows][cols];
		clearBoard();
		
	}

	protected void clearBoard(){
		for(int row=0; row<3; row++){
			for(int col=0; col<3; col++){
				_gameBoard[row][col] = Constants.UNOCCUPIED_SPACE;
			}
		}
	}
	
	protected void placeMove(char playerMove, Row r, Column c){
		
		int row = r.ordinal();
		int col = c.ordinal();
		
		_gameBoard[row][col] = playerMove;
	}
	
	protected boolean canMove(Row r, Column c){
		int row = r.ordinal();
		int col = c.ordinal();
		
		if(_gameBoard[row][col] == Constants.UNOCCUPIED_SPACE)
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		int UpperRow = Row.UPPER.ordinal();
		int MiddleRow = Row.MIDDLE.ordinal();
		int LowerRow = Row.LOWER.ordinal();
		
		int LeftColumn = Column.LEFT.ordinal();
		int MiddleColumn = Column.MIDDLE.ordinal();
		int RightColumn = Column.RIGHT.ordinal();
		
		return sb
		.append(_gameBoard[UpperRow][LeftColumn])
		.append(Constants.CELL_SPACER)
		.append(_gameBoard[UpperRow][MiddleColumn])
		.append(Constants.CELL_SPACER)
		.append(_gameBoard[UpperRow][RightColumn])
		.append(Constants.NEWLINE)
		.append(_gameBoard[MiddleRow][LeftColumn])
		.append(Constants.CELL_SPACER)
		.append(_gameBoard[MiddleRow][MiddleColumn])
		.append(Constants.CELL_SPACER)
		.append(_gameBoard[MiddleRow][RightColumn])
		.append(Constants.NEWLINE)
		.append(_gameBoard[LowerRow][LeftColumn])
		.append(Constants.CELL_SPACER)
		.append(_gameBoard[LowerRow][MiddleColumn])
		.append(Constants.CELL_SPACER)
		.append(_gameBoard[LowerRow][RightColumn])
		.toString();
	}
}
