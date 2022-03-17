package net.scilingo.board.tictactoe;

public class MoveUpperMiddle extends AbstractTicTacToeMove {

	
	public MoveUpperMiddle(TicTacToeGameBoard board){
		super(TicTacToeCellSelection.UPPER_MIDDLE, board);
	}
	
	@Override
	public boolean move(TicTacToePlayer player, boolean gameOver) {
		return super.placeMove(player, Row.UPPER, Column.MIDDLE, gameOver);
	}
	
	@Override 
	public String toString(){
		return "Move To Upper Center";
	}

}
