package net.scilingo.board.tictactoe;

public class MoveLowerMiddle extends AbstractTicTacToeMove {
	
	
	public MoveLowerMiddle(TicTacToeGameBoard board) {
		super(TicTacToeCellSelection.LOWER_MIDDLE, board);
	}
	
	@Override
	public boolean move(TicTacToePlayer player, boolean gameOver) {
		return super.placeMove(player, Row.LOWER, Column.MIDDLE, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Lower Center";
	}
}
