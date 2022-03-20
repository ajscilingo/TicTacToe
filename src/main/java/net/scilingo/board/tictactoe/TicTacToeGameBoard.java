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
		super(Constants.NUM_OF_ROWS,Constants.NUM_OF_COLS);
		clearBoard();
	}
	
	public final char getUpperLeftCell() {
		return gameBoard[UpperRow][LeftColumn];
	}
	
	public final char getUpperMiddleCell() {
		return gameBoard[UpperRow][MiddleColumn];
	}
	
	public final char getUpperRightCell() {
		return gameBoard[UpperRow][RightColumn];
	}
	
	public final char getMiddleLeftCell() {
		return gameBoard[MiddleRow][LeftColumn];
	}
	
	public final char getMiddleMiddleCell() {
		return gameBoard[MiddleRow][MiddleColumn];
	}
	
	public final char getMiddleRightCell() {
		return gameBoard[MiddleRow][RightColumn];
	}

	public final char getLowerLeftCell() {
		return gameBoard[LowerRow][LeftColumn];
	}
	
	public final char getLowerMiddleCell() {
		return gameBoard[LowerRow][MiddleColumn];
	}
	
	public final char getLowerRightCell() {
		return gameBoard[LowerRow][RightColumn];
	}
	
	protected void clearBoard(){
		for(int row=0; row<Constants.NUM_OF_ROWS; row++){
			for(int col=0; col<Constants.NUM_OF_COLS; col++){
				gameBoard[row][col] = Constants.UNOCCUPIED_SPACE;
			}
		}
	}
	
	protected void placeMove(char playerMove, Row r, Column c){
		
		int row = r.ordinal();
		int col = c.ordinal();
		
		gameBoard[row][col] = playerMove;
	}
	
	protected boolean canMove(Row r, Column c, boolean gameOver){
		int row = r.ordinal();
		int col = c.ordinal();
		
		if(gameBoard[row][col] == Constants.UNOCCUPIED_SPACE && gameOver == false)
			return true;
		return false;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		return sb
		.append(gameBoard[UpperRow][LeftColumn])
		.append(Constants.CELL_SPACER)
		.append(gameBoard[UpperRow][MiddleColumn])
		.append(Constants.CELL_SPACER)
		.append(gameBoard[UpperRow][RightColumn])
		.append(Constants.NEWLINE)
		.append(gameBoard[MiddleRow][LeftColumn])
		.append(Constants.CELL_SPACER)
		.append(gameBoard[MiddleRow][MiddleColumn])
		.append(Constants.CELL_SPACER)
		.append(gameBoard[MiddleRow][RightColumn])
		.append(Constants.NEWLINE)
		.append(gameBoard[LowerRow][LeftColumn])
		.append(Constants.CELL_SPACER)
		.append(gameBoard[LowerRow][MiddleColumn])
		.append(Constants.CELL_SPACER)
		.append(gameBoard[LowerRow][RightColumn])
		.toString();
	}
}
