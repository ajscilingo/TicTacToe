package scilingo.net.board;

public class Board {

	protected char [][] _gameBoard;
	private static String _newLine = System.getProperty("line.separator");
	private static int rows = 3;
	private static int cols = 3;
	
	private static int upperRow = Row.UPPER.ordinal();
	private static int centerRow = Row.MIDDLE.ordinal();
	private static int lowerRow = Row.LOWER.ordinal();
	
	private static int leftColumn = Column.LEFT.ordinal();
	private static int centerColumn = Column.MIDDLE.ordinal();
	private static int rightColumn = Column.RIGHT.ordinal();
	
	public Board(){
		_gameBoard = new char[rows][cols];
		clearBoard();
		
	}

	protected void clearBoard(){
		for(int row=0; row<3; row++){
			for(int col=0; col<3; col++){
				_gameBoard[row][col] = '_';
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
		
		if(_gameBoard[row][col] == '_')
			return true;
		return false;
	}
	
	protected boolean checkFirstRowForWin(){
		if(this._gameBoard[upperRow][leftColumn] == '_' ||  this._gameBoard[upperRow][centerColumn] == '_' || this._gameBoard[upperRow][rightColumn] == '_')
			return false;
		return (this._gameBoard[upperRow][leftColumn] == this._gameBoard[upperRow][centerColumn]) && (this._gameBoard[upperRow][centerColumn] == this._gameBoard[upperRow][rightColumn]);
	}
	
	protected boolean checkSecondRowForWin(){
		if(this._gameBoard[centerRow][leftColumn] == '_' || this._gameBoard[centerRow][centerColumn] == '_' || this._gameBoard[centerRow][rightColumn] == '_')
			return false;
		return (this._gameBoard[centerRow][leftColumn] == this._gameBoard[centerRow][centerColumn]) && (this._gameBoard[centerRow][centerColumn] == this._gameBoard[centerRow][rightColumn]);
	}
	
	protected boolean checkThirdRowForWin(){
		if(this._gameBoard[lowerRow][leftColumn] == '_' ||  this._gameBoard[lowerRow][centerColumn] == '_' || this._gameBoard[lowerRow][rightColumn] == '_')
			return false;
		return (this._gameBoard[lowerRow][leftColumn] == this._gameBoard[lowerRow][centerColumn]) && (this._gameBoard[lowerRow][centerColumn] == this._gameBoard[lowerRow][rightColumn]);
	}
	
	protected boolean checkFirstColumnForWin(){
		if(this._gameBoard[upperRow][leftColumn] == '_' || this._gameBoard[centerRow][leftColumn] == '_' || this._gameBoard[lowerRow][leftColumn] == '_')
			return false;
		return (this._gameBoard[upperRow][leftColumn] == this._gameBoard[centerRow][leftColumn]) && (this._gameBoard[centerRow][leftColumn] == this._gameBoard[lowerRow][leftColumn]);
	}
	
	protected boolean checkSecondColumnForWin(){
		if(this._gameBoard[upperRow][centerColumn] == '_' || this._gameBoard[centerRow][centerColumn] == '_' || this._gameBoard[lowerRow][centerColumn] == '_')
			return false;
		return (this._gameBoard[upperRow][centerColumn] == this._gameBoard[centerRow][centerColumn]) && (this._gameBoard[centerRow][centerColumn] == this._gameBoard[lowerRow][centerColumn]);
	}
	
	protected boolean checkThirdColumnForWin(){
		if(this._gameBoard[upperRow][rightColumn] == '_' || this._gameBoard[centerRow][rightColumn] == '_' || this._gameBoard[lowerRow][rightColumn] == '_')
			return false;
		return (this._gameBoard[upperRow][rightColumn] == this._gameBoard[centerRow][rightColumn]) && (this._gameBoard[centerRow][rightColumn] == this._gameBoard[lowerRow][rightColumn]);
	}
	
	protected boolean checkFirstDiagonal(){
		if(this._gameBoard[upperRow][leftColumn] == '_' || this._gameBoard[centerRow][centerColumn] == '_' || this._gameBoard[lowerRow][rightColumn] == '_')
			return false;
		return (this._gameBoard[upperRow][leftColumn] == this._gameBoard[centerRow][centerColumn]) && (this._gameBoard[centerRow][centerColumn] == this._gameBoard[lowerRow][rightColumn]);
	}
	
	protected boolean checkSecondDiagonal(){
		if(this._gameBoard[lowerRow][leftColumn] == '_' || this._gameBoard[centerRow][centerColumn] == '_' || this._gameBoard[upperRow][rightColumn] == '_')
			return false;
		return (this._gameBoard[lowerRow][leftColumn] == this._gameBoard[centerRow][centerColumn]) && (this._gameBoard[centerRow][centerColumn] == this._gameBoard[upperRow][rightColumn]);
	}
	
	/**
	 * Check For Winning Pattern
	 * There has to be a minimum of 5 moves
	 * For a win
	 * @return
	 */
	public boolean checkForWin(){
		if(checkFirstColumnForWin())
			return true;
		if(checkSecondColumnForWin())
			return true;
		if(checkThirdColumnForWin())
			return true;
		if(checkFirstRowForWin())
			return true;
		if(checkSecondRowForWin())
			return true;
		if(checkThirdRowForWin())
			return true;
		if(checkFirstDiagonal())
			return true;
		if(checkSecondDiagonal())
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		return sb.append(_gameBoard[0][0])
		.append("|")
		.append(_gameBoard[0][1])
		.append("|")
		.append(_gameBoard[0][2])
		.append(_newLine)
		.append(_gameBoard[1][0])
		.append("|")
		.append(_gameBoard[1][1])
		.append("|")
		.append(_gameBoard[1][2])
		.append(_newLine)
		.append(_gameBoard[2][0])
		.append("|")
		.append(_gameBoard[2][1])
		.append("|")
		.append(_gameBoard[2][2])
		.toString();
	}
}
