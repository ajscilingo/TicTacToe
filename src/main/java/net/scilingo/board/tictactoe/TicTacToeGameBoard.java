package net.scilingo.board.tictactoe;

import net.scilingo.board.AbstractGameBoard;
import net.scilingo.board.Constants;

public class TicTacToeGameBoard extends AbstractGameBoard {
	
	private static final int UpperRow = Row.UPPER.ordinal();
	private static final int MiddleRow = Row.MIDDLE.ordinal();
	private static final int LowerRow = Row.LOWER.ordinal();
	
	private static final int LeftColumn = Column.LEFT.ordinal();
	private static final int MiddleColumn = Column.MIDDLE.ordinal();
	private static final int RightColumn = Column.RIGHT.ordinal();

	
	TicTacToeGameBoard(){
		super(3,3);
		clearBoard();
	}
	
	public final char getUpperLeftCell() {
		return _gameBoard[UpperRow][LeftColumn];
	}
	
	public final char getUpperMiddleCell() {
		return _gameBoard[UpperRow][MiddleColumn];
	}
	
	public final char getUpperRightCell() {
		return _gameBoard[UpperRow][RightColumn];
	}
	
	public final char getMiddleLeftCell() {
		return _gameBoard[MiddleRow][LeftColumn];
	}
	
	public final char getMiddleMiddleCell() {
		return _gameBoard[MiddleRow][MiddleColumn];
	}
	
	public final char getMiddleRightCell() {
		return _gameBoard[MiddleRow][RightColumn];
	}

	public final char getLowerLeftCell() {
		return _gameBoard[LowerRow][LeftColumn];
	}
	
	public final char getLowerMiddleCell() {
		return _gameBoard[LowerRow][MiddleColumn];
	}
	
	public final char getLowerRightCell() {
		return _gameBoard[LowerRow][RightColumn];
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
	
	protected boolean canMove(Row r, Column c, boolean gameOver){
		int row = r.ordinal();
		int col = c.ordinal();
		
		if(_gameBoard[row][col] == Constants.UNOCCUPIED_SPACE && gameOver == false)
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
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
