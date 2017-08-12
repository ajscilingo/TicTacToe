package scilingo.net.board;

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
		return sb.append(_gameBoard[0][0])
		.append("|")
		.append(_gameBoard[0][1])
		.append("|")
		.append(_gameBoard[0][2])
		.append(Constants.NEWLINE)
		.append(_gameBoard[1][0])
		.append("|")
		.append(_gameBoard[1][1])
		.append("|")
		.append(_gameBoard[1][2])
		.append(Constants.NEWLINE)
		.append(_gameBoard[2][0])
		.append("|")
		.append(_gameBoard[2][1])
		.append("|")
		.append(_gameBoard[2][2])
		.toString();
	}
}
