package net.scilingo.board.tictactoe;

public class MoveLowerRight extends AbstractTicTacToeMove {
	
	public MoveLowerRight(TicTacToeGameBoard board) {
		super(TicTacToeCellSelection.LOWER_RIGHT, board);
	}
	
	@Override
	public boolean move(TicTacToePlayer player, boolean gameOver) {
		return super.placeMove(player, Row.LOWER, Column.RIGHT, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Right";
	}
}
